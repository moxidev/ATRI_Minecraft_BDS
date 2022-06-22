package net.moxi.exploration.atri

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.BotEvent
import net.mamoe.mirai.utils.info
import net.moxi.exploration.atri.behaviour.WarmWelcome
import net.moxi.exploration.atri.config.SelfConfiguration
import net.moxi.exploration.atri.config.ServiceUser

object Plugin : KotlinPlugin(
    JvmPluginDescription(
        id = "net.moxi.exploration.atri.plugin",
        version = "1.0-SNAPSHOT",
    )
) {
    override fun onEnable() {
        logger.info { "Plugin loaded" }

        // init the configuration
        SelfConfiguration.reload()
        ServiceUser.reload()

        val channel = GlobalEventChannel
            .filterIsInstance<BotEvent>()
            .filter { it.bot.id == SelfConfiguration.botQQIdentifier }
            .exceptionHandler { exception ->
                exception.printStackTrace()
            }
        WarmWelcome(channel).run()
    }
}