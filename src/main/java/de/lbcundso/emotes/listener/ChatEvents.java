package de.lbcundso.emotes.listener;

import de.lbcundso.emotes.Main;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatEvents implements Listener {

    @EventHandler
    public void onChatEmote(AsyncPlayerChatEvent e) {
        String msg = e.getMessage();
        ConfigurationSection emotes = Main.getPlugin().getConfig().getConfigurationSection("emotes");
        if (emotes == null) return;
        for (String em : emotes.getKeys(false)) {
            if (e.getMessage().toLowerCase().contains(":" + em + ":")) {
                String emoteChar = Main.getPlugin().getConfig().getString("emotes." + em + ".char");
                if (emoteChar == null) return;
                String newMSG = msg.replace(":" + em + ":", emoteChar);
                e.setMessage(newMSG);
            }
        }
    }
}
