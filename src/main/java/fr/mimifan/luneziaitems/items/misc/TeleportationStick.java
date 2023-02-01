package fr.mimifan.luneziaitems.items.misc;

import fr.mimifan.luneziaitems.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeleportationStick {

    public static ItemStack item(final int quantity){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Main.getInstance().getConfig().getString("customItems.tp_stick.name").replace("&","§"));
        meta.setLore(Main.getInstance().getConfig().getStringList("customItems.tp_stick.lore"));
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);
        item.setAmount(quantity);
        return item;
    }

    public static ItemStack item(){
        return item(1);
    }

}
