package fr.mimifan.luneziaitems.api.itemfiles;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.api.configuration.YamlConfigurationFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class LunaireConfigurationFile extends YamlConfigurationFile {
    private static LunaireConfigurationFile instance = new LunaireConfigurationFile(Main.getInstance());

    public LunaireConfigurationFile(JavaPlugin plugin) {
        super("lunaire-items", plugin);
    }

    public static LunaireConfigurationFile getInstance() {
        return instance;
    }
}
