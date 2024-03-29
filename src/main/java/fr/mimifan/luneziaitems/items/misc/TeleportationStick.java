package fr.mimifan.luneziaitems.items.misc;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.utils.CustomStrings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class TeleportationStick implements LuneziaItem {

    private static HashMap<Player, Location> tp_point = new HashMap<Player, Location>();
    private static HashMap<Player, Long> cooldown = new HashMap<Player, Long>();
    public static int cooldown_time = Main.getInstance().getConfig().getInt("customItems.tp_stick.cooldown");

    public static ItemStack item(final int quantity){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Main.getInstance().getConfig().getString("customItems.tp_stick.name").replace("&","§"));
        meta.setLore(CustomStrings.replaceStringList("customItems.tp_stick.lore"));
        if(Main.getInstance().getConfig().getBoolean("customItems.tp_stick.hide-enchants")) meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);
        item.setAmount(quantity);
        return item;
    }

    public static ItemStack item(){
        return item(1);
    }

    public static HashMap<Player, Location> getTp_point() {
        return tp_point;
    }
    public static HashMap<Player, Long> getCooldown() {
        return cooldown;
    }

    @Override
    public ItemStack getItemStack() {
        return null;
    }

    @Override
    public @Nullable String getTag() {
        return "teleportation-stick";
    }
}
