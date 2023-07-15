package fr.mimifan.luneziaitems.utils;

import org.bukkit.inventory.ItemStack;

public class ItemCompare {
    public static boolean equals(final ItemStack item1, final ItemStack item2){
        if(!(item1.hasItemMeta() && item2.hasItemMeta())) return false;
        if(!item1.getItemMeta().getDisplayName().equalsIgnoreCase(item2.getItemMeta().getDisplayName())) return false;
        return item1.getItemMeta().getEnchants().toString().equalsIgnoreCase(item2.getItemMeta().getEnchants().toString());
    }

}
