package net.moxi.exploration.atri.util

import net.mamoe.mirai.contact.Contact.Companion.uploadImage
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.utils.ExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.moxi.exploration.atri.Plugin
import net.moxi.exploration.atri.Plugin.dataFolderPath
import net.moxi.exploration.atri.config.SelfConfiguration
import java.io.File


suspend fun sendExpressionImageRandom(group: Group, typePath: String) {
    val file = randomGetOneFile(SelfConfiguration.botExpressionPath + "\\$typePath")
    group.sendMessage(group.uploadImage(file))
}

suspend fun getExpressionImageRandom(group:Group,typePath: String): Image {
    val file = randomGetOneFile(SelfConfiguration.botExpressionPath + "\\$typePath")
    return group.uploadImage(file)
}