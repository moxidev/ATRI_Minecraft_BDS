package net.moxi.exploration.atri.config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.value
import net.moxi.exploration.atri.Plugin.dataFolderPath

object SelfConfiguration:AutoSavePluginConfig("SelfConfiguration") {
    var botNickname by value(listOf("ATRI","亚托莉"))
    var botQQIdentifier by value(1245678L)
    var botExpressionPath by value(dataFolderPath.toString())
}