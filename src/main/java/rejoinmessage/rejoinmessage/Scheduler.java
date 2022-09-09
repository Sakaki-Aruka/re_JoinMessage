package rejoinmessage.rejoinmessage;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import static rejoinmessage.rejoinmessage.Login.*;

public class Scheduler extends BukkitRunnable {
    @Override
    public void run(){

        for (String loop : sendCommands.get(0)){
            schedulerServer.dispatchCommand(Bukkit.getConsoleSender(),loop);
        }
        sendCommands.remove(0);
    }
}
