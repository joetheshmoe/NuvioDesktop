package com.nuvio.app

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

/**
 * Simple JSON-file-based storage for desktop platform.
 * Stores all values in ~/.config/nuvio/storage.json as a flat JSON map.
 * Thread-safe via synchronized block.
 */
object DesktopStorage {
    private val json = Json { ignoreUnknownKeys = true; prettyPrint = true }
    private val storageDir: Path = Path.of(System.getProperty("user.home"), ".config", "nuvio")
    private val storageFile: Path = storageDir.resolve("storage.json")
    private var cache: MutableMap<String, String> = mutableMapOf()

    init {
        Files.createDirectories(storageDir)
        loadFromDisk()
    }

    private fun loadFromDisk() {
        try {
            if (Files.exists(storageFile)) {
                val text = Files.readString(storageFile)
                val obj = json.parseToJsonElement(text).jsonObject
                cache = obj.mapValues { it.value.toString().trim('"') }.toMutableMap()
            }
        } catch (_: Exception) {
            cache = mutableMapOf()
        }
    }

    private fun saveToDisk() {
        try {
            val text = json.encodeToString(
                kotlinx.serialization.serializer<Map<String, String>>(),
                cache.toMap()
            )
            Files.writeString(storageFile, text, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
        } catch (_: Exception) { }
    }

    @Synchronized
    fun get(key: String): String? = cache[key]?.takeIf { it.isNotEmpty() }

    @Synchronized
    fun getBoolean(key: String): Boolean? = cache[key]?.toBooleanStrictOrNull()

    @Synchronized
    fun getInt(key: String): Int? = cache[key]?.toIntOrNull()

    @Synchronized
    fun getFloat(key: String): Float? = cache[key]?.toFloatOrNull()

    @Synchronized
    fun put(key: String, value: String) {
        cache[key] = value
        saveToDisk()
    }

    @Synchronized
    fun putBoolean(key: String, value: Boolean) {
        cache[key] = value.toString()
        saveToDisk()
    }

    @Synchronized
    fun putInt(key: String, value: Int) {
        cache[key] = value.toString()
        saveToDisk()
    }

    @Synchronized
    fun putFloat(key: String, value: Float) {
        cache[key] = value.toString()
        saveToDisk()
    }

    @Synchronized
    fun remove(key: String) {
        cache.remove(key)
        saveToDisk()
    }

    @Synchronized
    fun clearAll() {
        cache.clear()
        saveToDisk()
    }
}
