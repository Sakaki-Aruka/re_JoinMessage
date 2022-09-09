package rejoinmessage.rejoinmessage;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

import static rejoinmessage.rejoinmessage.Login.*;

public class Scheduler extends BukkitRunnable {
    @Override
    public void run(){

        String name = nameArr.get(0);
        Map<Integer,String> map = new SettingsLoad().commands;

        for(Map.Entry<Integer,String> entry : map.entrySet()){
            String command = entry.getValue();
            command =command.replace("!ppp!",name);

            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),command);

            //debug
            System.out.println("command:"+command);
        }
        nameArr.remove(0);
        cancel();
    }
}
