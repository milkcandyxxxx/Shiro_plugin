package org.example.shiro_plugin.plugins;

import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.AnyMessageEvent;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
//@Shiro
public class History extends BotPlugin {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public int onAnyMessage(Bot bot, AnyMessageEvent event){
        String group_id;
        if (event.getGroupId() == null) {
            group_id = "私聊";
        } else {
            group_id = event.getGroupId().toString();
        }

        // 转换为北京时间（东八区）
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(event.getTime()), ZoneId.of("Asia/Shanghai"));
        System.out.println(dateTime.format(fmt)+" "
                +event.getSender().getNickname()+
                "[" +event.getUserId()+"]["+group_id+"] "
                +event.getRawMessage());

        return MESSAGE_IGNORE;
    }

}
