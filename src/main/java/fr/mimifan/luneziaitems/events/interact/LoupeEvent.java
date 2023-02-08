package fr.mimifan.luneziaitems.events.interact;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class LoupeEvent {

    public static void use(PlayerInteractEvent event){
        event.setCancelled(true);
        Player player = event.getPlayer();
        if(!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if(!(event.getClickedBlock().getType() == Material.CHEST)) return;
        final Inventory chest = ((Chest) event.getClickedBlock().getState()).getInventory();
        Inventory chestView = Bukkit.createInventory(null, chest.getSize(), "§eLoupe");
        chestView.setContents(chest.getContents());
        player.openInventory(chestView);

    }

}
