package rejoinmessage.rejoinmessage;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class Events implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event){
        new Login().login(event);
    }
}
