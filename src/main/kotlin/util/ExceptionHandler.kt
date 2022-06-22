package net.moxi.exploration.atri.util

import net.moxi.exploration.atri.Plugin

fun printTrackToConsole(message:Exception){
    Plugin.logger.error(message.toString())
}

fun printTrackToConsole(message:String){
    Plugin.logger.error(message)
}