package rejoinmessage.rejoinmessage;

import org.bukkit.Bukkit;
import org.bukkit.Server;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Map;

public class Login {
    public static Player schedulePlayer;
    public static Server schedulerServer;
    public static ArrayList<ArrayList<String>> sendCommands = new ArrayList<>();

    public void login(PlayerLoginEvent event){
        schedulePlayer = event.getPlayer();
        schedulerServer = Bukkit.getServer();
        Map<Integer,String> map = new SettingsLoad().commands;
        ArrayList<String> childArr = new ArrayList<>();

        Plugin plugin = Bukkit.getPluginManager().getPlugin("ReJoinMessage");
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            String command = entry.getValue();
            command =command.replace("!ppp!",schedulePlayer.getName());

            childArr.add(command);
        }
        sendCommands.add(childArr);
        childArr.clear();
        new Scheduler().runTaskLater(plugin,100L);
    }
}
