package net.moxi.exploration.atri.behaviour

import io.ktor.util.reflect.*
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.BotEvent
import net.mamoe.mirai.event.events.GroupMemberEvent
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.MemberJoinEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.PlainText
import net.moxi.exploration.atri.Plugin
import net.moxi.exploration.atri.config.SelfConfiguration
import net.moxi.exploration.atri.config.ServiceUser
import net.moxi.exploration.atri.util.probabilityBool
import net.moxi.exploration.atri.util.randomTakeItem
import net.moxi.exploration.atri.util.sendExpressionImageRandom

/**
 * 热情欢迎 应用于主群
 * @author MoxiOrz
 * @date 2022/6/21 10:09
 */
class WarmWelcome(private val channel: EventChannel<BotEvent>) {

    fun run() {
        // 处理邀请入群 (主群)
        channel.subscribeAlways<GroupMessageEvent> { event ->
            if (event.group.id == ServiceUser.mainGroupServices) {
                val name = SelfConfiguration.botNickname.randomTakeItem()
                val probability = 1
                val replyMessage = listOf<String>(
                    "欢迎新人(ૢ˃ꌂ˂⁎)\n" +
                            "${name}等你好久啦\n" +
                            "有问题都可以问我哦",
                    "笨蛋！你怎么才来\n" +
                            "${name}可等不了你那么久\n" +
                            "我才不会回答你任何问题\n" +
                            "（￣へ￣）",
                    "(＞﹏＜)\n" +
                            "欢迎..欢迎...～\n" +
                            "${name}没力气了",
                    ""
                )

                var test = replyMessage.randomTakeItem()
                if (test == "" || test.isEmpty()) {
                    test = replyMessage.randomTakeItem()
                }

                event.group.sendMessage(At(event.sender) + PlainText("\n" + test))
                Plugin.logger.info(Plugin.dataFolderPath.toString())
                if (probabilityBool(0.2)) sendExpressionImageRandom(group, "expression\\happy")
            }
        }
    }
}