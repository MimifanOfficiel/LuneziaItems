package fr.mimifan.luneziaitems.api.items;

import org.bukkit.event.player.PlayerItemConsumeEvent;

public interface Consumable {
    void onConsume(PlayerItemConsumeEvent e);
}
