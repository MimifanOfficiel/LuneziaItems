package fr.mimifan.luneziaitems.items.misc;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.utils.CustomStrings;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Loupe {

    public static ItemStack item(final int quantity){
        ItemStack item = new ItemStack(Material.GOLD_INGOT);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Main.getInstance().getConfig().getString("customItems.loupe.name").replace("&","§"));
        meta.setLore(CustomStrings.replaceStringList("customItems.loupe.lore"));
        if(Main.getInstance().getConfig().getBoolean("customItems.loupe.hide-enchants")) meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
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
