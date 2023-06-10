package fr.mimifan.luneziaitems.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class HydrusHoeMineEvent extends BlockBreakEvent {
    public HydrusHoeMineEvent(Block block, Player player) {
        super(block, player);
    }
}
