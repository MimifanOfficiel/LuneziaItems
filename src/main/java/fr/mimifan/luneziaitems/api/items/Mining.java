package fr.mimifan.luneziaitems.api.items;

import org.bukkit.event.block.BlockBreakEvent;

public interface Mining {
    default void onBlockBreak(BlockBreakEvent e) {}
    default void onNaturalBlockBreak(BlockBreakEvent event) {}

}
