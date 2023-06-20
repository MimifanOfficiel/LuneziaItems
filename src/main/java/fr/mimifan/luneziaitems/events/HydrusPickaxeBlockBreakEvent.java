package fr.mimifan.luneziaitems.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class HydrusPickaxeBlockBreakEvent extends BlockBreakEvent {
    public HydrusPickaxeBlockBreakEvent(Block block, Player player) {
        super(block, player);
    }
}
