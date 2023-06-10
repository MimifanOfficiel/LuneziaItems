package fr.mimifan.luneziaitems.listeners;

import fr.mimifan.luneziaitems.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class PlaceBlockListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        event.getBlockPlaced().setMetadata("placedByPlayer", new FixedMetadataValue(Main.getInstance(), true));
    }

}
