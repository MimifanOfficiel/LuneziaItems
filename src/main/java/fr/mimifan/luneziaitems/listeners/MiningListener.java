package fr.mimifan.luneziaitems.listeners;

import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.api.items.Mining;
import fr.mimifan.luneziaitems.managers.ItemManager;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class MiningListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getItemInHand();
        LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(itemInHand));

        if (luneziaItem instanceof Mining) {
            if (event.getPlayer().getGameMode() == GameMode.CREATIVE) return;
            if (event.getBlock().getMetadata("placed-by-player").isEmpty()) {
                ((Mining) luneziaItem).onNaturalBlockBreak(event);
            }
            ((Mining) luneziaItem).onBlockBreak(event);
        }
    }
}
