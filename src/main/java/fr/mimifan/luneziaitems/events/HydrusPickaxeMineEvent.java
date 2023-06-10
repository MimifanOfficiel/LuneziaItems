package fr.mimifan.luneziaitems.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class HydrusPickaxeMineEvent extends BlockBreakEvent {
    public HydrusPickaxeMineEvent(Block block, Player player) {
        super(block, player);
    }
}
