package fr.mimifan.luneziaitems.listeners.mine.hydrus;

import fr.mimifan.luneziaitems.listeners.MiningListener;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class HydrusToolsBlockBreakListener implements Listener {
    /*@EventHandler
    public void axeBlockBreakEvent(HydrusAxeBlockBreakEvent event) {
        Block block = event.getBlock();

        Location loc = block.getLocation();
        switch (block.getType()){

        }
    }

    @EventHandler
    public void shovelBlockBreakEvent(HydrusShovelBlockBreakEvent event) {
        final Block block = event.getBlock();
        Location loc = block.getLocation();
        switch (block.getType()) {
            case DIRT, SAND, GRAVEL, GRASS, MYCEL ->
                    MiningListener.dropLoot(loc, new ItemStack(block.getType()));
            default -> {
            }
        }
    }*/


}
