package fr.mimifan.luneziaitems.events;

import fr.mimifan.luneziaitems.events.interact.LoupeEvent;
import fr.mimifan.luneziaitems.events.interact.TeleportationStickEvent;
import fr.mimifan.luneziaitems.items.misc.Loupe;
import fr.mimifan.luneziaitems.items.misc.TeleportationStick;
import fr.mimifan.luneziaitems.utils.ItemCompare;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(ItemCompare.equals(event.getPlayer().getItemInHand(), TeleportationStick.item())){
            TeleportationStickEvent.use(event);
        } else if(ItemCompare.equals(event.getPlayer().getItemInHand(), Loupe.item())){
            LoupeEvent.use(event);
        }
    }







}
