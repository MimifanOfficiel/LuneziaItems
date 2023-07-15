package fr.mimifan.luneziaitems.listeners;

import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.api.items.Wearable;
import fr.mimifan.luneziaitems.managers.ItemManager;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getClickedInventory() == null) return;
        if(event.getView().getTopInventory().getTitle().equals("§eLoupe")) { event.setCancelled(true); return;}

        if(event.getClickedInventory().getHolder() instanceof HumanEntity){
            Player player = (Player) event.getWhoClicked();
            if(!(event.getClickedInventory().getHolder() == player)) return;
            LuneziaItem cursor = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(event.getCursor())),
                    currentItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(event.getCurrentItem()));

            if(cursor instanceof Wearable) ((Wearable) cursor).onInventoryClick(event);
            if(currentItem instanceof Wearable) ((Wearable) currentItem).onInventoryClick(event);
        }
    }
}
