package fr.mimifan.luneziaitems.listeners.mine.hydrus;

import fr.mimifan.luneziaitems.events.HydrusAxeMineEvent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class HydrusAxeMined implements Listener {
    @EventHandler
    public void onBreak(HydrusAxeMineEvent event) {
        Block block = event.getBlock();

        Location loc = block.getLocation();
        switch (block.getType()){

        }
    }
}
