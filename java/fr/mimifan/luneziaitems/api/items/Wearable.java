package fr.mimifan.luneziaitems.api.items;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public interface Wearable {

    default void onDamageByPlayer(EntityDamageByEntityEvent event) {}

    default void onCloseInventory(InventoryCloseEvent event) {}

    default void onInventoryClick(InventoryClickEvent event) {}

    default void onInteract(PlayerInteractEvent event){}
    default void addEffects(Player player) {}

    default void removeEffects(Player player) {}

}
