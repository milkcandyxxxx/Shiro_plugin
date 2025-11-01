package org.example.shiro_plugin.plugins;

import com.mikuac.shiro.annotation.MessageHandlerFilter;
import com.mikuac.shiro.annotation.AnyMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;

import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.AnyMessageEvent;
import org.springframework.stereotype.Component;
import oshi.SystemInfo;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

import java.util.List;
import java.util.regex.Matcher;

//是@AnyMessageHandler，只有满足的语句才会触发（奶糖感觉不就应该全部写成这样吗qwq）
@Component
@Shiro
public class Echo extends BotPlugin {
    @AnyMessageHandler
    @MessageHandlerFilter(cmd = "^#echo\\s(.*)?$")
    public void onMessage(Bot bot, AnyMessageEvent event, Matcher matcher) {
//        SystemInfo sys = new SystemInfo();
//        OperatingSystem system = sys.getOperatingSystem();
//        System.out.printf(system.getFamily());
//        List<OSFileStore> system_storage = system.getFileSystem().getFileStores();
//        for (OSFileStore file : system_storage) {
//            System.out.println(file.getName());
//            System.out.printf("%dGB\n", file.getTotalSpace() / 1024 / 1024 / 1024);
//            System.out.println(file.getUsableSpace());
//            System.out.println(file.getFreeSpace());
//        }
        System.out.println("收到消息" + matcher.group(1));
        bot.sendMsg(event, "收到消息" + matcher.group(1), false);
//           仅作为学习获取id
//            StrangerInfoResp user=bot.getStrangerInfo(event.getUserId(),false).getData();
//            System.out.println(user.getUserId()+user.getNickname());

    }
}
