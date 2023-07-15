package fr.mimifan.luneziaitems.api.itemfiles;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.api.configuration.YamlConfigurationFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class HydrusConfigurationFile extends YamlConfigurationFile {
    private static HydrusConfigurationFile instance = new HydrusConfigurationFile(Main.getInstance());

    public HydrusConfigurationFile(JavaPlugin plugin) {
        super("hydrus-items", plugin);
    }

    public static HydrusConfigurationFile getInstance() {
        return instance;
    }
}
