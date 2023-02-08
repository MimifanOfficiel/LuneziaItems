package fr.mimifan.luneziaitems;

import fr.mimifan.luneziaitems.commands.CommandlItems;
import fr.mimifan.luneziaitems.events.InteractEvent;
import fr.mimifan.luneziaitems.events.InventoryClick;
import fr.mimifan.luneziaitems.events.MiningEvent;
import fr.mimifan.luneziaitems.events.PlaceEvent;
import fr.mimifan.luneziaitems.recipes.LuneziaRecipes;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        getLogger().info("Starting up...");
        LuneziaRecipes.loadAllRecipes();
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MiningEvent(), this);
        pm.registerEvents(new PlaceEvent(), this);
        pm.registerEvents(new InteractEvent(), this);
        pm.registerEvents(new InventoryClick(), this);

        getCommand("lItems").setExecutor(new CommandlItems());
    }

    public static Main getInstance(){
        return instance;
    }

    @Override
    public void onDisable() {

    }
}
