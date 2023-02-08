package fr.mimifan.luneziaitems.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(!event.getView().getTopInventory().getTitle().equals("§eLoupe")) return;
        event.setCancelled(true);
    }

}
