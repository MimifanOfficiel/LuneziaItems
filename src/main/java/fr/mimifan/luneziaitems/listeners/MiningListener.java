package fr.mimifan.luneziaitems.listeners;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.listeners.mine.hydrus.HydrusAxeMined;
import fr.mimifan.luneziaitems.listeners.mine.hydrus.HydrusHoeMined;
import fr.mimifan.luneziaitems.listeners.mine.hydrus.HydrusPickaxeMined;
import fr.mimifan.luneziaitems.listeners.mine.hydrus.HydrusShovelMined;
import fr.mimifan.luneziaitems.items.hydrus.tools.HydrusAxe;
import fr.mimifan.luneziaitems.items.hydrus.tools.HydrusHoe;
import fr.mimifan.luneziaitems.items.hydrus.tools.HydrusPickaxe;
import fr.mimifan.luneziaitems.items.hydrus.tools.HydrusShovel;
import fr.mimifan.luneziaitems.utils.ItemCompare;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class MiningListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(!event.getBlock().getMetadata("placedByPlayer").isEmpty()){ event.getBlock().removeMetadata("placedByPlayer", Main.getInstance()); return;}
        if(event.getPlayer().getGameMode() == GameMode.CREATIVE) return;
        ItemStack tool = event.getPlayer().getItemInHand();
        if(ItemCompare.equals(tool, HydrusPickaxe.item())){
            HydrusPickaxeMined.execute(event.getBlock());
        } else if(ItemCompare.equals(tool, HydrusAxe.item())){
            HydrusAxeMined.execute(event.getBlock());
        } else if(ItemCompare.equals(tool, HydrusShovel.item())){
            HydrusShovelMined.execute(event.getBlock());
        } else if(ItemCompare.equals(tool, HydrusHoe.item())){
            HydrusHoeMined.execute(event.getBlock());
        }
    }

    public static void dropLoot(Location loc, ItemStack drop) {
        loc.getWorld().dropItemNaturally(loc, drop);
    }

}
