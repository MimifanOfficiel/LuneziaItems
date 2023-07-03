package fr.mimifan.luneziaitems.api.items.blocks;

import org.bukkit.event.player.PlayerInteractEvent;

public interface BlockInteractable {
    default void onInteract(PlayerInteractEvent e) {}
}
