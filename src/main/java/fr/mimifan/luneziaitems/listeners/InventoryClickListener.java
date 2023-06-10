package fr.mimifan.luneziaitems.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(!event.getView().getTopInventory().getTitle().equals("§eLoupe")) return;
        event.setCancelled(true);
    }

}
