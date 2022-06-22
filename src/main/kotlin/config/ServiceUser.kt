package net.moxi.exploration.atri.config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.value

object ServiceUser :AutoSavePluginConfig("ServiceUser") {
    var mainGroupServices by value(123456789L)
}