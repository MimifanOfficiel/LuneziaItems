package fr.mimifan.luneziaitems.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class HydrusAxeBlockBreakEvent extends BlockBreakEvent {
    public HydrusAxeBlockBreakEvent(Block block, Player player) {
        super(block, player);
    }
}
