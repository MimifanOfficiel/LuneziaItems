package fr.mimifan.luneziaitems.listeners.mine.hydrus;

import fr.mimifan.luneziaitems.listeners.MiningListener;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class HydrusShovelMined {

    public static void execute(Block block) {
        Location loc = block.getLocation();
        switch (block.getType()) {
            case DIRT, SAND, GRAVEL, GRASS, MYCEL -> MiningListener.dropLoot(loc, new ItemStack(block.getType()));
            default -> {
            }
        }
    }

}
