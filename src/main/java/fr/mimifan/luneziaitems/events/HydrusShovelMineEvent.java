package fr.mimifan.luneziaitems.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class HydrusShovelMineEvent extends BlockBreakEvent {
    public HydrusShovelMineEvent(Block block, Player player) {
        super(block, player);
    }
}
