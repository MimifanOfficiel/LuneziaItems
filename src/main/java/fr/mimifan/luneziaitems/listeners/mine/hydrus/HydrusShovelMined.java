package fr.mimifan.luneziaitems.listeners.mine.hydrus;

import fr.mimifan.luneziaitems.events.HydrusShovelMineEvent;
import fr.mimifan.luneziaitems.listeners.MiningListener;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class HydrusShovelMined implements Listener {
    @EventHandler
    public void onBreak(HydrusShovelMineEvent event) {
        final Block block = event.getBlock();
        Location loc = block.getLocation();
        switch (block.getType()) {
            case DIRT, SAND, GRAVEL, GRASS, MYCEL ->
                    MiningListener.dropLoot(loc, new ItemStack(block.getType()));
            default -> {
            }
        }
    }

}
