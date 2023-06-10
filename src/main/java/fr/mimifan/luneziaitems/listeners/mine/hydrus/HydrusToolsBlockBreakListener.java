package fr.mimifan.luneziaitems.listeners.mine.hydrus;

import fr.mimifan.luneziaitems.events.HydrusAxeBlockBreakEvent;
import fr.mimifan.luneziaitems.events.HydrusHoeBlockBreakEvent;
import fr.mimifan.luneziaitems.events.HydrusPickaxeBlockBreakEvent;
import fr.mimifan.luneziaitems.events.HydrusShovelBlockBreakEvent;
import fr.mimifan.luneziaitems.listeners.MiningListener;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class HydrusToolsBlockBreakListener implements Listener {
    @EventHandler
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
    }

    @EventHandler
    public void pickaxeBlockBreakEvent(HydrusPickaxeBlockBreakEvent event) {
        final Block block = event.getBlock();
        Location loc = block.getLocation();
        switch (block.getType()) {
            case REDSTONE_ORE, IRON_ORE, OBSIDIAN, LAPIS_ORE, GOLD_ORE, DIAMOND_ORE ->
                    MiningListener.dropLoot(loc, new ItemStack(block.getType()));
            default -> {
            }
        }
    }

    @EventHandler
    public void hoeBlockBreakEvent(HydrusHoeBlockBreakEvent event) {
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
