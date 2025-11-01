package org.example.shiro_plugin.plugins;

import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import org.springframework.stereotype.Component;

@Component
@Shiro
public class Ping_test extends BotPlugin {
    @Override
    public int onGroupMessage(Bot bot, GroupMessageEvent event) {
        // 打印完整事件信息（包含框架默认输出的字段）

        String msg = event.getMessage();
        if (msg.equals("ping")) {
            String reply = "pong";
            bot.sendGroupMsg(event.getGroupId(), reply, false);
            return MESSAGE_BLOCK;
        }
        return MESSAGE_IGNORE;
    }
}
