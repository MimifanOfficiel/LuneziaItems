package fr.mimifan.luneziaitems.events.mine.hydrus;

import fr.mimifan.luneziaitems.events.MiningEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
public class HydrusPickaxeMined {
    public static void execute(final Block block){
        Location loc = block.getLocation();
        switch (block.getType()){
            case REDSTONE_ORE:
                MiningEvent.dropLoot(loc, new ItemStack(Material.REDSTONE_ORE));
                break;
            case IRON_ORE:
                MiningEvent.dropLoot(block.getLocation(), new ItemStack(Material.IRON_ORE));
                break;
            case OBSIDIAN:
                MiningEvent.dropLoot(block.getLocation(), new ItemStack(Material.OBSIDIAN));
                break;
            case LAPIS_ORE:
                MiningEvent.dropLoot(block.getLocation(), new ItemStack(Material.LAPIS_ORE));
                break;
            case GOLD_ORE:
                MiningEvent.dropLoot(block.getLocation(), new ItemStack(Material.GOLD_ORE));
                break;
            case DIAMOND_ORE:
                MiningEvent.dropLoot(block.getLocation(), new ItemStack(Material.DIAMOND_ORE));
                break;
            default:
                break;
        }
    }

}
