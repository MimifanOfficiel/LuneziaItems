package fr.mimifan.luneziaitems.api.items.blocks;

import org.bukkit.event.player.PlayerInteractEvent;

public interface BlockPlaceable {
    default void onBlockPlace(PlayerInteractEvent e) {}
}
