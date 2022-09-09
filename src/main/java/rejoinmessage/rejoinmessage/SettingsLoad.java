package rejoinmessage.rejoinmessage;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class SettingsLoad {
    public static FileConfiguration FC;

    public void fc(FileConfiguration fileConfiguration){
        FC = fileConfiguration;
        this.configLoad();
    }

    public static int actions;
    public static Map<Integer,String> commands = new HashMap<>();

    public String replace(String chat,String type,String value,String color){
        String returnTo = "tellraw !ppp! {\"text\":\"!ttt!\",\"color\":\"!ccc!\",\"clickEvent\":{\"action\":\"!aaa!\",\"value\":\"!vvv!\"}}";
        returnTo = returnTo.replace("!ttt!",chat);
        returnTo = returnTo.replace("!aaa!",type);
        returnTo = returnTo.replace("!vvv!",value);
        returnTo = returnTo.replace("!ccc!",color);
        return returnTo;
    }

    private void configLoad(){
        actions = FC.getInt("actions");

        // !ppp! is player(target)
        // !ccc! is color
        // !ttt! is text
        // !aaa! is action type
        // !vvv! is action value

        for (int i=1;i <= actions;i++){
            String path = "action"+i+".";
            String actionType = FC.getString(path+"type");
            String chatText = FC.getString(path+"message");
            String color = FC.getString(path+"color");
            if(color.equals("")){
                color = "white";
            }

            if(actionType.equals("command")){
                // command action
                actionType = "run_command";
                String command = FC.getString(path+"command");
                String value = this.replace(chatText,actionType,command,color);
                commands.put(i,value);

            }else if(actionType.equals("url")){
                // open url action
                actionType = "open_url";
                String url = FC.getString(path+"url");
                String value = this.replace(chatText,actionType,url,color);
                commands.put(i,value);

            }else if(actionType.equals("clipboard")){
                // clipboard action
                actionType = "copy_to_clipboard";
                String clipboard = FC.getString(path+"copy");
                String value = this.replace(chatText,actionType,clipboard,color);
                commands.put(i,value);

            }else if(actionType.equals("suggest_command")){
                // command suggest action
                actionType = "suggest_command";
                String suggest = FC.getString(path+"suggest");
                String value = this.replace(chatText,actionType,suggest,color);
                commands.put(i,value);

            }else if(actionType.equals("normal")){
                // normal
                String value = "tellraw !ppp! {\"text\":\""+chatText+"\",\"color\":\""+color+"\"}";
                commands.put(i,value);
            }
        }
    }
}
