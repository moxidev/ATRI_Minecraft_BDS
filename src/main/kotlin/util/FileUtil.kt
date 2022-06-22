package net.moxi.exploration.atri.util

import java.io.File

suspend fun randomGetOneFile(fpath:String): File {
    printTrackToConsole(fpath)
    val fileNames: MutableList<String> = mutableListOf()
    val fileTree: FileTreeWalk = File(fpath).walk()
    fileTree.maxDepth(1)
        .filter { it.isFile }
        .filter { it.extension in listOf("png","jpg") }
        .forEach { fileNames.add(it.name) }
    fileNames.forEach(::println)
    printTrackToConsole(fileNames.toString())
    return File("$fpath\\${fileNames.randomTakeItem()} ")
}