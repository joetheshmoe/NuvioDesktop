package com.nuvio.app.features.addons

import com.nuvio.app.DesktopStorage
import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod
import io.ktor.http.ContentType
import io.ktor.http.contentType

private val httpClient = HttpClient(Java) {
    followRedirects = true
}

internal actual object AddonStorage {
    private fun keyInstalledUrls(profileId: Int) = "addon_installed_urls_$profileId"
    private fun keyEnabledStates(profileId: Int) = "addon_enabled_states_$profileId"

    actual fun loadInstalledAddonUrls(profileId: Int): List<String> {
        val raw = DesktopStorage.get(keyInstalledUrls(profileId)) ?: return emptyList()
        return raw.split("\n").filter { it.isNotBlank() }
    }

    actual fun saveInstalledAddonUrls(profileId: Int, urls: List<String>) {
        DesktopStorage.put(keyInstalledUrls(profileId), urls.joinToString("\n"))
    }

    actual fun loadAddonEnabledStates(profileId: Int): Map<String, Boolean> {
        val raw = DesktopStorage.get(keyEnabledStates(profileId)) ?: return emptyMap()
        return raw.lines().mapNotNull { line ->
            val parts = line.split(":", limit = 2)
            if (parts.size == 2) parts[0] to (parts[1].toBooleanStrictOrNull() ?: true) else null
        }.toMap()
    }

    actual fun saveAddonEnabledStates(profileId: Int, states: Map<String, Boolean>) {
        val raw = states.entries.joinToString("\n") { "${it.key}:${it.value}" }
        DesktopStorage.put(keyEnabledStates(profileId), raw)
    }
}

actual suspend fun httpGetText(url: String): String {
    return httpClient.request(url).bodyAsText()
}

actual suspend fun httpPostJson(url: String, body: String): String {
    return httpClient.request(url) {
        method = HttpMethod.Post
        contentType(ContentType.Application.Json)
        setBody(body)
    }.bodyAsText()
}

actual suspend fun httpGetTextWithHeaders(
    url: String,
    headers: Map<String, String>,
): String {
    return httpClient.request(url) {
        headers.forEach { (k, v) -> header(k, v) }
    }.bodyAsText()
}

actual suspend fun httpPostJsonWithHeaders(
    url: String,
    body: String,
    headers: Map<String, String>,
): String {
    return httpClient.request(url) {
        method = HttpMethod.Post
        contentType(ContentType.Application.Json)
        headers.forEach { (k, v) -> header(k, v) }
        setBody(body)
    }.bodyAsText()
}

actual suspend fun httpRequestRaw(
    method: String,
    url: String,
    headers: Map<String, String>,
    body: String,
    followRedirects: Boolean,
): RawHttpResponse {
    val response = httpClient.request(url) {
        this.method = HttpMethod.parse(method)
        headers.forEach { (k, v) -> header(k, v) }
        if (body.isNotEmpty()) { setBody(body) }
    }
    val statusCode = response.status.value
    val responseHeaders = response.headers.entries().associate { (k, v) -> k to v.joinToString(", ") }
    val responseBody = response.bodyAsText()
    return RawHttpResponse(
        status = statusCode,
        statusText = response.status.description,
        url = url,
        body = responseBody,
        headers = responseHeaders,
    )
}
