package fr.mimifan.luneziaitems;

import fr.mimifan.luneziaitems.api.configuration.ConfigurationFile;
import fr.mimifan.luneziaitems.api.itemfiles.HydrusConfigurationFile;
import fr.mimifan.luneziaitems.api.itemfiles.LunaireConfigurationFile;
import fr.mimifan.luneziaitems.commands.CommandLItems;
import fr.mimifan.luneziaitems.items.fragments.NeutralFragment;
import fr.mimifan.luneziaitems.items.fragments.SolarFragment;
import fr.mimifan.luneziaitems.items.hydrus.mining.HydrusAxe;
import fr.mimifan.luneziaitems.items.hydrus.mining.HydrusHoe;
import fr.mimifan.luneziaitems.items.hydrus.mining.HydrusPickaxe;
import fr.mimifan.luneziaitems.items.hydrus.mining.HydrusShovel;
import fr.mimifan.luneziaitems.items.lunaire.armor.LunaireBoots;
import fr.mimifan.luneziaitems.items.lunaire.armor.LunaireChestplate;
import fr.mimifan.luneziaitems.items.lunaire.armor.LunaireHelmet;
import fr.mimifan.luneziaitems.items.lunaire.armor.LunaireLeggings;
import fr.mimifan.luneziaitems.managers.ItemManager;
import fr.mimifan.luneziaitems.managers.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Main extends JavaPlugin {

    private static Main instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        getLogger().info("Starting up...");

        getLogger().info("Loading configuration files");
        loadConfigurations();

        getLogger().info("Loading Items");
        loadItems();

        getLogger().info("Loading command");
        getCommand("litems").setExecutor(new CommandLItems());

        getLogger().info("Loading PlayerManager");
        PlayerManager.getInstance().load();
    }


    public void loadConfigurations(){
        ConfigurationFile.getInstance().load();
        HydrusConfigurationFile.getInstance().load();
        LunaireConfigurationFile.getInstance().load();
    }

    public void loadItems(){
        ItemManager.getInstance().unload();

        ItemManager.getInstance().register(List.of(
                new HydrusAxe(),
                new HydrusHoe(),
                new HydrusPickaxe(),
                new HydrusShovel(),
                new NeutralFragment(),
                new SolarFragment(),

                new LunaireHelmet(),
                new LunaireChestplate(),
                new LunaireLeggings(),
                new LunaireBoots()
        ));

        ItemManager.getInstance().load();
    }

    public static Main getInstance(){
        return instance;
    }

    @Override
    public void onDisable() {
        ItemManager.getInstance().unload();
        PlayerManager.getInstance().unload();
        instance = null;
    }
}
