package fr.mimifan.luneziaitems.listeners;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.api.items.*;
import fr.mimifan.luneziaitems.blocks.StorageManager;
import fr.mimifan.luneziaitems.managers.ItemManager;
import fr.mimifan.luneziaitems.managers.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
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
    public void onJoin(PlayerJoinEvent event) {
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerManager.getInstance().register(event.getPlayer());
            }
        });
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerManager.getInstance().unregister(event.getPlayer());
            }
        });
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        ItemStack itemInHand = e.getItem();
        LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(itemInHand));

        if (luneziaItem instanceof Interactable) {
            ((Interactable) luneziaItem).onInteract(e);
        }

        BlockItem clickedBlock = ItemManager.getInstance().get(e.getClickedBlock());

        if (clickedBlock != null) {
            clickedBlock.onInteract(e);
        }

        if (e.getClickedBlock() == null || !e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        if (luneziaItem instanceof BlockItem blockItem) {
            Location location = e.getClickedBlock().getLocation().add(e.getBlockFace().getModX(), e.getBlockFace().getModY(), e.getBlockFace().getModZ());

            blockItem.onBlockPlace(e);

            if (!e.isCancelled()) {
                e.setCancelled(true);

                // TODO: check if there is an entity where the block is placed

                location.getBlock().setType(blockItem.getBlockType());
                StorageManager.getInstance().register(location.getBlock(), blockItem.getTag());

                if (!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
                    if (itemInHand.getAmount() == 1) {
                        e.getPlayer().setItemInHand(new ItemStack(Material.AIR));
                    } else {
                        itemInHand.setAmount(itemInHand.getAmount() - 1);
                    }
                }
            }
        }
    }

}
