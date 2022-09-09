# re_JoinMessage
When a player join a server in first time, sends clickable messages and gives unique items.  
# Config.yml settings  
## actions  
How many actions(messages that send to players)  
## action(x)  
(x) is a number that start 1.  
### message 
Set a message that displayed to players chat line.  
### type  
Set action type that select from url,clipboard,suggest_command,normal,command(deprecation)  
- url -> open url
- clipboard -> The string when that clicked by player, add the string that was set ,to players clipboard.  
- suggest_command -> suggest a command to a joined player.  
- normal -> no actions has  
### color  
Set strings color. (you can use color code, and some color names.)  
### (x)  
should Set a parameter that appropriate for selected type(url,clipboard,suggest_command...) instead of (x).  
  
example):  
↓  
type: url  
url: "https://google.com"  
