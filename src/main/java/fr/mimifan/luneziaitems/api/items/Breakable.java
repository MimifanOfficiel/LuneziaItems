package fr.mimifan.luneziaitems.api.items;

import org.bukkit.event.player.PlayerItemBreakEvent;

public interface Breakable {
    void onBreak(PlayerItemBreakEvent e);
}
