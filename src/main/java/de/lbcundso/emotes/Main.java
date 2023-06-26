package de.lbcundso.emotes;

import de.lbcundso.emotes.commands.EmoteList;
import de.lbcundso.emotes.listener.ChatEvents;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Main extends JavaPlugin {

    private static Plugin plugin;

    public static Plugin getPlugin(){return plugin;}

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        Configuration cfg = Main.getPlugin().getConfig();
        if(!cfg.contains("emotes")){
            cfg.set("emotes.name.char", "Dies ist ein Testemote, das in der config ist. Um Emotes hinzuzufügen, konfiguriere die config.yml des Plugins und lade das Plugin neu.");
        }
        Bukkit.getPluginManager().registerEvents(new ChatEvents(), this);
        Bukkit.getPluginCommand("emotes").setExecutor(new EmoteList());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
