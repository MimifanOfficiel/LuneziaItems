package fr.mimifan.luneziaitems.items.hydrus.tools;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.utils.CustomStrings;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HydrusAxe {

    public static ItemStack item(final int quantity){
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.getInstance().getConfig().getString("customItems.hydrus.axe.name").replace("&", "§"));

        meta.addEnchant(Enchantment.SILK_TOUCH, 1, false);
        meta.addEnchant(Enchantment.DURABILITY, 3, false);
        meta.addEnchant(Enchantment.DIG_SPEED, 7, true);

        meta.setLore(CustomStrings.replaceStringList("customItems.hydrus.axe.lore"));
        if(Main.getInstance().getConfig().getBoolean("customItems.hydrus.axe.hide-enchants")) meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);
        item.setAmount(quantity);
        return item;
    }

    public static ItemStack item(){
        return item(1);
    }

}
