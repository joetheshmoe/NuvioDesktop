package com.nuvio.app.features.downloads

import java.io.File
import java.io.FileOutputStream
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal actual object DownloadsPlatformDownloader {
    actual fun start(
        request: DownloadPlatformRequest,
        onProgress: (downloadedBytes: Long, totalBytes: Long?) -> Unit,
        onSuccess: (localFileUri: String, totalBytes: Long?) -> Unit,
        onFailure: (message: String) -> Unit,
    ): DownloadsTaskHandle {
        val thread = Thread {
            try {
                val url = URL(request.sourceUrl)
                val connection = url.openConnection()
                request.sourceHeaders.forEach { (k, v) -> connection.setRequestProperty(k, v) }
                val totalBytes = connection.contentLengthLong.let { if (it < 0) null else it }
                val inputStream = connection.getInputStream()
                val file = File(System.getProperty("java.io.tmpdir"), request.destinationFileName)
                file.outputStream().use { output ->
                    val buffer = ByteArray(8192)
                    var bytesRead: Int
                    var totalRead = 0L
                    while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                        output.write(buffer, 0, bytesRead)
                        totalRead += bytesRead
                        onProgress(totalRead, totalBytes)
                    }
                }
                inputStream.close()
                onSuccess(file.toURI().toString(), totalBytes)
            } catch (e: Exception) {
                onFailure(e.message ?: "Download failed")
            }
        }.apply { start() }
        return object : DownloadsTaskHandle {
            override fun cancel() { thread.interrupt() }
        }
    }

    actual fun removeFile(localFileUri: String?): Boolean {
        if (localFileUri == null) return false
        return try { File(java.net.URI(localFileUri)).delete() } catch (_: Exception) { false }
    }

    actual fun removePartialFile(destinationFileName: String): Boolean {
        return try { File(System.getProperty("java.io.tmpdir"), destinationFileName).delete() } catch (_: Exception) { false }
    }

    actual fun resolveLocalFileUri(localFileUri: String?, destinationFileName: String): String? {
        if (localFileUri != null) return localFileUri
        val file = File(System.getProperty("java.io.tmpdir"), destinationFileName)
        return if (file.exists()) file.toURI().toString() else null
    }
}
