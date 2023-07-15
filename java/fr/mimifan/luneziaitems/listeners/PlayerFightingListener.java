package fr.mimifan.luneziaitems.listeners;

import fr.mimifan.luneziaitems.api.items.Fighting;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.api.items.Wearable;
import fr.mimifan.luneziaitems.managers.ItemManager;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerFightingListener implements Listener {

    @EventHandler
    public void onPlayerFighting(EntityDamageByEntityEvent event){
        if( (event.getEntity() instanceof Player) && (event.getDamager() instanceof Player) ){
            Player damaged = (Player) event.getEntity(), damager = (Player) event.getDamager();
            for (ItemStack armorContent : damaged.getInventory().getArmorContents()) {

                LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(armorContent));

                if(luneziaItem instanceof Wearable) ((Wearable) luneziaItem).onDamageByPlayer(event);

            }

            ItemStack damageItem = damager.getInventory().getItemInHand();
            LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(damageItem));

            if(luneziaItem instanceof Fighting) ((Fighting) luneziaItem).onDamageToPlayer(event);

        }
    }

}
