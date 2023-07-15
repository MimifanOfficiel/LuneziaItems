package fr.mimifan.luneziaitems.items.lunaire.armor;

import fr.mimifan.luneziaitems.api.itemfiles.LunaireConfigurationFile;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.api.items.Wearable;
import fr.mimifan.luneziaitems.managers.ItemManager;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class LunaireLeggings implements LuneziaItem, Wearable {

    private ItemStack itemStack;

    public LunaireLeggings(){
        itemStack = LunaireConfigurationFile.getInstance().getLuneziaItem(getTag());
    }

    @Override
    public ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public @NotNull String getTag() {
        return "lunaire-leggings";
    }

    @Override
    public void onDamageByPlayer(EntityDamageByEntityEvent event) {

    }

    @Override
    public void onCloseInventory(InventoryCloseEvent event) {
        addEffects((Player) event.getPlayer());
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event){
        LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(event.getCursor()));

        if(luneziaItem == null) return;
        if(luneziaItem.getItemStack().equals(itemStack)){
            removeEffects((Player) event.getWhoClicked());
        }
    }

    @Override
    public void addEffects(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 1, false));
    }

    @Override
    public void removeEffects(Player player){
        player.removePotionEffect(PotionEffectType.SPEED);
    }
}
