package fr.mimifan.luneziaitems;

import fr.mimifan.luneziaitems.commands.CommandlItems;
import fr.mimifan.luneziaitems.events.HydrusAxeMineEvent;
import fr.mimifan.luneziaitems.listeners.InteractListener;
import fr.mimifan.luneziaitems.listeners.InventoryClickListener;
import fr.mimifan.luneziaitems.listeners.MiningListener;
import fr.mimifan.luneziaitems.listeners.PlaceBlockListener;
import fr.mimifan.luneziaitems.listeners.mine.hydrus.HydrusAxeMined;
import fr.mimifan.luneziaitems.listeners.mine.hydrus.HydrusHoeMined;
import fr.mimifan.luneziaitems.listeners.mine.hydrus.HydrusPickaxeMined;
import fr.mimifan.luneziaitems.listeners.mine.hydrus.HydrusShovelMined;
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

        pm.registerEvents(new MiningListener(), this);
        pm.registerEvents(new PlaceBlockListener(), this);
        pm.registerEvents(new InteractListener(), this);
        pm.registerEvents(new InventoryClickListener(), this);

        pm.registerEvents(new HydrusAxeMined(), this);
        pm.registerEvents(new HydrusHoeMined(), this);
        pm.registerEvents(new HydrusPickaxeMined(), this);
        pm.registerEvents(new HydrusShovelMined(), this);

        getCommand("lItems").setExecutor(new CommandlItems());
    }

    public static Main getInstance(){
        return instance;
    }

    @Override
    public void onDisable() {

    }
}
