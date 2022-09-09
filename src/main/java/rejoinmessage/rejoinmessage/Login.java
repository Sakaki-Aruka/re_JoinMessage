package rejoinmessage.rejoinmessage;

import org.bukkit.event.player.PlayerLoginEvent;
import java.util.ArrayList;

public class Login {
    public static ArrayList<String> nameArr = new ArrayList<>();

    public void login(PlayerLoginEvent event){

        nameArr.add(event.getPlayer().getName());
        new Scheduler().runTaskLater(ReJoinMessage.getPlugin(),100L);

    }
}
