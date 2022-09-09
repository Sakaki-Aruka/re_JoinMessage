package rejoinmessage.rejoinmessage;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.Map;

import static rejoinmessage.rejoinmessage.SettingsLoad.commands;

public class Login {
    public void login(PlayerLoginEvent event){
        Player player = event.getPlayer();
        Map<Integer,String> map = commands;
        ConsoleCommandSender sender = Bukkit.getConsoleSender();
        Server server = Bukkit.getServer();

        for(Map.Entry<Integer,String> entry : map.entrySet()){
            String command = entry.getValue().replace("!ppp!",player.getName());
            server.dispatchCommand(sender,command);
        }
    }
}
