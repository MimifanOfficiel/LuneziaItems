package fr.mimifan.luneziaitems.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;

public class HydrusAxeMineEvent extends BlockBreakEvent {
    public HydrusAxeMineEvent(Block block, Player player) {
        super(block, player);
    }
}
