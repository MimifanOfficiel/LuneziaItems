package fr.mimifan.luneziaitems.listeners;

import fr.mimifan.luneziaitems.listeners.interact.LoupeListener;
import fr.mimifan.luneziaitems.listeners.interact.TeleportationStickEvent;
import fr.mimifan.luneziaitems.items.misc.Loupe;
import fr.mimifan.luneziaitems.items.misc.TeleportationStick;
import fr.mimifan.luneziaitems.utils.ItemCompare;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(ItemCompare.equals(event.getPlayer().getItemInHand(), TeleportationStick.item())){
            TeleportationStickEvent.use(event);
        } else if(ItemCompare.equals(event.getPlayer().getItemInHand(), Loupe.item())){
            LoupeListener.use(event);
        }
    }

}
