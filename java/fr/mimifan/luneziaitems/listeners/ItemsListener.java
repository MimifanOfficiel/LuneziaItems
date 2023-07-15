package fr.mimifan.luneziaitems.listeners;

import fr.mimifan.luneziaitems.api.items.Craftable;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.managers.ItemManager;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class ItemsListener implements Listener {
    @EventHandler
    public void onCraft(CraftItemEvent e) {
        ItemStack itemInHand = e.getCurrentItem();
        LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(itemInHand));

        if (luneziaItem == null) return;

        if (luneziaItem instanceof Craftable) {
            ((Craftable) luneziaItem).onCraft(e);
        }
    }

    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent event){
        LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(event.getRecipe().getResult()));

        if(luneziaItem == null) return;

        if(luneziaItem instanceof Craftable){
            ((Craftable) luneziaItem).prepareCraft(event);
        }
    }
}
