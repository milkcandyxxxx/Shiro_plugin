package org.example.shiro_plugin.plugins;
import com.mikuac.shiro.annotation.MessageHandlerFilter;
import com.mikuac.shiro.annotation.AnyMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;

import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.action.common.ActionData;
import com.mikuac.shiro.dto.action.response.StrangerInfoResp;
import com.mikuac.shiro.dto.event.message.AnyMessageEvent;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
//是@AnyMessageHandler，只有满足的语句才会触发（奶糖感觉不就应该全部写成这样吗qwq）
@Component
@Shiro
public class Get_user_information extends BotPlugin {
        @AnyMessageHandler
        @MessageHandlerFilter(cmd = "^#echo\s(.*)?$")
        public void onMessage(Bot bot, AnyMessageEvent event, Matcher matcher) {
            System.out.println("收到消息"+ matcher.group(1));
            bot.sendMsg(event, "收到消息"+ matcher.group(1), false);
//           仅作为学习获取id
//            StrangerInfoResp user=bot.getStrangerInfo(event.getUserId(),false).getData();
//            System.out.println(user.getUserId()+user.getNickname());

        }
}
