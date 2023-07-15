package fr.mimifan.luneziaitems.listeners;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.api.items.*;
import fr.mimifan.luneziaitems.managers.ItemManager;
import fr.mimifan.luneziaitems.managers.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class PlayersListener implements Listener {
    @EventHandler
    public void onItemConsume(PlayerItemConsumeEvent e) {
        Player player = e.getPlayer();
        ItemStack itemInHand = player.getItemInHand();
        LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(itemInHand));

        if (luneziaItem == null) return;

        if (luneziaItem instanceof Consumable) {
            ((Consumable) luneziaItem).onConsume(e);
        }
    }

    @EventHandler
    public void onPlayerItemBreak(PlayerItemBreakEvent e) {
        ItemStack itemInHand = e.getBrokenItem();
        LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(itemInHand));

        if (luneziaItem == null) return;

        if (luneziaItem instanceof Breakable) {
            ((Breakable) luneziaItem).onBreak(e);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerManager.getInstance().register(event.getPlayer());
            }
        });
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerManager.getInstance().unregister(event.getPlayer());
            }
        });
    }

}
