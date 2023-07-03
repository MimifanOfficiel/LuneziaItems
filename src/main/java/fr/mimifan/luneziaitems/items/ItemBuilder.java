package fr.mimifan.luneziaitems.items;

import fr.mimifan.luneziaitems.managers.ItemManager;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    private Material material = Material.AIR;

    private String name;
    private String skullOwner;
    private String tag;
    private List<String> lore = new ArrayList<>();
    private List<Enchantment> enchantments = new ArrayList<>();
    private List<Integer> enchantmentsLevels = new ArrayList<>();
    private Integer durability = 0, quantity = 1;
    private Byte dataValue = 0;
    private boolean hideEnchants = false;

    public ItemBuilder(String tag){
        this.tag = tag;
    }

    public ItemBuilder setMaterial(Material material){
        this.material = material;
        return this;
    }

    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setSkullOwner(String skullOwner) {
        this.skullOwner = skullOwner;
        return this;
    }

    public ItemBuilder setLore(@NotNull List<String> lore) {
        this.lore = lore;
        return this;
    }

    public ItemBuilder setEnchantments(@NotNull List<Enchantment> enchantments) {
        this.enchantments = enchantments;
        return this;
    }

    public ItemBuilder addEnchantment(@NotNull Enchantment enchantment, int level){
        enchantments.add(enchantment);
        enchantmentsLevels.add(level);
        return this;
    }

    public ItemBuilder setDurability(Integer durability) {
        this.durability = durability;
        return this;
    }

    public ItemBuilder setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ItemBuilder setDataValue(Byte dataValue) {
        this.dataValue = dataValue;
        return this;
    }

    public ItemBuilder setHideEnchants(boolean hideEnchants) {
        this.hideEnchants = hideEnchants;
        return this;
    }


    public ItemStack build(){
        ItemStack itemStack = new ItemStack(material, ((quantity == null) ? 1 : quantity), dataValue);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta != null){
            if (itemMeta instanceof SkullMeta) { ((SkullMeta) itemMeta).setOwner(this.skullOwner); }

            itemMeta.setDisplayName(name);
            itemMeta.setLore(lore);
            if(hideEnchants) itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            itemStack.setItemMeta(itemMeta);

            for (int i = 0; i < enchantments.size(); i++) {
                itemStack.addUnsafeEnchantment(enchantments.get(i), enchantmentsLevels.get(i));
            }

            net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(itemStack);

            NBTTagCompound nbtTagCompound = nmsItem.getTag();
            if (nbtTagCompound == null) { nbtTagCompound = new NBTTagCompound(); }

            nbtTagCompound.setString(ItemManager.LUNEZIA_ITEM_TAG, tag);

            nmsItem.setTag(nbtTagCompound);

            itemStack = CraftItemStack.asBukkitCopy(nmsItem);
        }
        return itemStack;
    }


}
