package fr.mimifan.luneziaitems.api.items;

import org.bukkit.event.player.PlayerInteractEvent;

public interface Interactable {
    void onInteract(PlayerInteractEvent e);
}
