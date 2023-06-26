package de.lbcundso.emotes.commands;

import de.lbcundso.emotes.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EmoteList implements CommandExecutor {

    private static String prefix = "§7[§aEmotes§7] §r";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(prefix + "Dieser Befehl kann nur von Spielern ausgeführt werden.");
            return false;
        }
        Player plr = (Player) sender;
        List<String> emoteChars = new ArrayList<String>();
        ConfigurationSection emotes = Main.getPlugin().getConfig().getConfigurationSection("emotes");
        if (emotes == null) {
            plr.sendMessage(prefix + "Es wurden keine Emotes in der Konfiguration gefunden.");
            return false;
        }

        for (String em : emotes.getKeys(false)) {
                String emoteChar = Main.getPlugin().getConfig().getString("emotes." + em + ".char");
                if (emoteChar == null) continue;
                emoteChars.add(emoteChar + "(:" + em + ":)");
            }
        String emoteList = emoteChars.toString().replace("[", "").replace("]", "").replace(",", ", ");
        plr.sendMessage(prefix + "Es gibt folgende Emotes:");
        plr.sendMessage(emoteList);
        return false;
    }
}
