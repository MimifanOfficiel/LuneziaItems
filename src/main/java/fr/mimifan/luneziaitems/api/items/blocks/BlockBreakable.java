package fr.mimifan.luneziaitems.api.items.blocks;

import org.bukkit.event.block.BlockBreakEvent;

public interface BlockBreakable {
    void onBlockBreak(BlockBreakEvent e);
}
