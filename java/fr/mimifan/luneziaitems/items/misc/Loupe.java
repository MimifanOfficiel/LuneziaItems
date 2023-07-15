package fr.mimifan.luneziaitems.items.misc;

import fr.mimifan.luneziaitems.api.configuration.ConfigurationFile;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.items.ItemBuilder;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class Loupe implements LuneziaItem {

    private ItemStack itemStack;

    public Loupe(){
        ConfigurationFile configurationFile = ConfigurationFile.getInstance();
        itemStack = new ItemBuilder(getTag())
                .setName(configurationFile.getMessage("custom-items." + getTag() + ".name"))
                .setLore(configurationFile.getMessageList("custom-items." + getTag() + ".lore"))
                .setHideEnchants(configurationFile.getBoolean("custom-items." + getTag() + ".hide-enchants"))
                .addEnchantment(Enchantment.DURABILITY, 1)
                .build();
    }
    @Override
    public ItemStack getItemStack() { return itemStack; }

    @Override
    public @Nullable String getTag() { return "loupe"; }
}
