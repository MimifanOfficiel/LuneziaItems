package fr.mimifan.luneziaitems.api.items.blocks;

import org.bukkit.event.block.BlockBreakEvent;

public interface BlockBreakable {
    default void onBlockBreak(BlockBreakEvent e) {}
}
