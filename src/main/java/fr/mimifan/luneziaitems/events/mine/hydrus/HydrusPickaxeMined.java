package fr.mimifan.luneziaitems.events.mine.hydrus;

import fr.mimifan.luneziaitems.events.MiningEvent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
public class HydrusPickaxeMined {
    public static void execute(final Block block){
        Location loc = block.getLocation();
        switch (block.getType()) {
            case REDSTONE_ORE, IRON_ORE, OBSIDIAN, LAPIS_ORE, GOLD_ORE, DIAMOND_ORE ->
                    MiningEvent.dropLoot(loc, new ItemStack(block.getType()));
            default -> {
            }
        }
    }

}
