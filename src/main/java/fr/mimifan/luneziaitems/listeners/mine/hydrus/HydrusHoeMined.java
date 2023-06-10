package fr.mimifan.luneziaitems.listeners.mine.hydrus;

import fr.mimifan.luneziaitems.listeners.MiningListener;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class HydrusHoeMined {

    public static void execute(Block block) {
        Location loc = block.getLocation();
        switch (block.getType()) {
            case CROPS, POTATO, CARROT, WHEAT, BROWN_MUSHROOM, RED_MUSHROOM -> {
                if (block.getData() == (byte) 7) {
                    for (ItemStack item : block.getDrops()) {
                        MiningListener.dropLoot(loc, item);
                    }
                }
            }
        }
    }

}
