package fr.mimifan.luneziaitems.events.mine.hydrus;

import fr.mimifan.luneziaitems.events.MiningEvent;
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
                        MiningEvent.dropLoot(loc, item);
                    }
                }
            }
        }
    }

}
