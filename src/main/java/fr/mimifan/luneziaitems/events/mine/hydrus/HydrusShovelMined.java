package fr.mimifan.luneziaitems.events.mine.hydrus;

import fr.mimifan.luneziaitems.events.MiningEvent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class HydrusShovelMined {

    public static void execute(Block block) {
        Location loc = block.getLocation();
        switch (block.getType()) {
            case DIRT, SAND, GRAVEL, GRASS, MYCEL -> MiningEvent.dropLoot(loc, new ItemStack(block.getType()));
            default -> {
            }
        }
    }

}
