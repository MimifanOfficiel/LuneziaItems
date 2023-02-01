package fr.mimifan.luneziaitems;

import fr.mimifan.luneziaitems.commands.CommandlItems;
import fr.mimifan.luneziaitems.events.MiningEvent;
import fr.mimifan.luneziaitems.events.PlaceEvent;
import fr.mimifan.luneziaitems.items.fragments.NeutralFragment;
import fr.mimifan.luneziaitems.items.fragments.SolarFragment;
import fr.mimifan.luneziaitems.recipes.LuneziaRecipes;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Starting up...");
        LuneziaRecipes.loadAllRecipes();
        Bukkit.getPluginManager().registerEvents(new MiningEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlaceEvent(), this);

        getCommand("lItems").setExecutor(new CommandlItems());
    }

    public static Main getInstance(){
        return instance;
    }

    @Override
    public void onDisable() {

    }
}
