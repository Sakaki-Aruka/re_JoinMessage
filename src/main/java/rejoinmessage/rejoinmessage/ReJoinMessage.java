package rejoinmessage.rejoinmessage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import static rejoinmessage.rejoinmessage.SettingsLoad.commands;

public final class ReJoinMessage extends JavaPlugin implements CommandExecutor {

    private void load(){
        FileConfiguration fileConfiguration = getConfig();
        new SettingsLoad().fc(fileConfiguration);
    }

    @Override
    public void onEnable() {
        this.load();
        getServer().getPluginManager().registerEvents(new Events(),this);
        getCommand("joinmessagereload");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        sender.sendMessage("§eNow reloading.(re-JoinMessage plugin)");
        this.load();
        sender.sendMessage("load info\n:"+commands);
        sender.sendMessage("§aReload finished.(re-JoinMessage plugin)");
        return true;
    }
}
