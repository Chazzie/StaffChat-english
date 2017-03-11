package chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
	
	}		
	public boolean onCommand(CommandSender s, Command cmd,	String label, String[] args) {
		if (s instanceof Player) {
			Player p = (Player) s;
			if (cmd.getName().equalsIgnoreCase("staffchat")) {
                if (!s.hasPermission("staffchat.use")) {
                    s.sendMessage("�a[�cStaff�3Chat�a] " + ChatColor.RED + "You don't have permissions to do that!");
                    return true;
                }
                if (args.length == 0) {
                    s.sendMessage("�a[�cStaff�3Chat�a] " + ChatColor.RED + "Sorry, but we can't send this to the other staff. because there's nothing to send!");
                    return true;
				}
				if (args.length > 0) {
					StringBuilder b = new StringBuilder();
					for (int i = 0; i < args.length; i++) { 
						b.append(" ");
						b.append(args[i]);
					}
					String message = b.toString();
					for (Player all : Bukkit.getServer().getOnlinePlayers()) {
						if (all.hasPermission("staffchat.use")) { 
							
							all.sendMessage("�a[�cStaff�3Chat�a] " + ChatColor.RESET + p.getDisplayName() + ": " + ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', message));
						}
					}
				}
			}
		}
		
		return false;		
	}
	
}