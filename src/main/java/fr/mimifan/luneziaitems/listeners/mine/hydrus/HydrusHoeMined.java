package fr.mimifan.luneziaitems.listeners.mine.hydrus;

import fr.mimifan.luneziaitems.events.HydrusHoeMineEvent;
import fr.mimifan.luneziaitems.listeners.MiningListener;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class HydrusHoeMined implements Listener {
    @EventHandler
    public void onBreak(HydrusHoeMineEvent event) {
        Block block = event.getBlock();
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
