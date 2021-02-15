package com.project.WireMockRegister

import java.io.File

interface FileReader {
    fun getFileNames(dataDir: String): List<String> {
        val resource = javaClass.classLoader.getResource(dataDir.trimStart('/')) ?: return emptyList()
        return resource.file
            .let(::File)
            .listFiles()
            .map { it.name }
    }

    fun readFiles(directory: String) = javaClass.getResourceAsStream(directory).bufferedReader().readLines()
    fun read(fileName: String) = javaClass.getResourceAsStream(fileName).bufferedReader().readLines().joinToString("\n")
}