package fr.mimifan.luneziaitems.listeners;

import fr.mimifan.luneziaitems.api.items.Consumable;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.api.items.Wearable;
import fr.mimifan.luneziaitems.managers.ItemManager;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryCloseListener implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){
        if(!event.getInventory().getHolder().equals(event.getPlayer())) return;
        ItemStack[] armor = event.getPlayer().getInventory().getArmorContents();
        for (ItemStack itemStack : armor) {
            LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(itemStack));

            if (luneziaItem == null) continue;
            if (luneziaItem instanceof Wearable) {
                ((Wearable) luneziaItem).onCloseInventory(event);
            }
        }

    }


}
