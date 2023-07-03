package fr.mimifan.luneziaitems.api.items.blocks;

import org.bukkit.event.player.PlayerInteractEvent;

public interface BlockPlaceable {
    void onBlockPlace(PlayerInteractEvent e);
}
