package org.example.shiro_plugin.plugins;
import com.mikuac.shiro.annotation.AnyMessageHandler;
import com.mikuac.shiro.annotation.MessageHandlerFilter;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.AnyMessageEvent;
import org.springframework.stereotype.Component;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

@Component
@Shiro
public class Get_system_information extends BotPlugin {
//    使用OSHI 系统监控库
//    先创建对象，避免每次触发都重新创建
    SystemInfo system_information = new SystemInfo();
    HardwareAbstractionLayer hal = system_information.getHardware();
    OperatingSystem system = system_information.getOperatingSystem();
    @AnyMessageHandler
    @MessageHandlerFilter(cmd = "^#系统信息查询\\s(.*)?$")

    public void onMessage(Bot bot, AnyMessageEvent event, Matcher matcher) {
        switch (matcher.group(1).toLowerCase().trim()){
            case "cpu":
                CentralProcessor cpu = hal.getProcessor();
                long[] time_slice = cpu.getSystemCpuLoadTicks();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("cpu占用获取中断"+e);
                }
                double cpu_usage = cpu.getSystemCpuLoadBetweenTicks(time_slice) * 100;

                System.out.printf("cpu型号:%s\n",cpu.getProcessorIdentifier().getName());
                System.out.printf("cpu占用率:%.2f%%\n", cpu_usage);
                break;
            case "运行时间":
                System.out.println(system.getSystemUptime());
                break;
            case "内存":
                System.out.printf("内存总量:%.2fGB\n",(double)hal.getMemory().getTotal()/1024/1024/1024);
                System.out.printf("可用内存:%.2fGB\n",(double)hal.getMemory().getAvailable()/1024/1024/1024);
                System.out.printf("占用率:%.2f%%\n",(double)((hal.getMemory().getTotal()-hal.getMemory().getAvailable())*1.0/hal.getMemory().getTotal()*100));



        }

    }

}
