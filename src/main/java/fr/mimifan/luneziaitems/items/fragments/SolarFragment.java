package fr.mimifan.luneziaitems.items.fragments;

import fr.mimifan.luneziaitems.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SolarFragment {

    public static ItemStack item(final int quantity){
        ItemStack item = new ItemStack(Material.INK_SACK);
        item.setDurability((short)14);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.getInstance().getConfig().getString("customItems.solar_fragment.name").replace("&","§"));

        item.setItemMeta(meta);
        item.setAmount(quantity);
        return item;
    }

    public static ItemStack item(){
        return item(1);
    }

}
