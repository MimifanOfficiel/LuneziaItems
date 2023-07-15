package fr.mimifan.luneziaitems.items.fragments;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.api.configuration.ConfigurationFile;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

public class NeutralFragment implements LuneziaItem {

    private ItemStack itemStack;

    public NeutralFragment(){
        ConfigurationFile configurationFile = ConfigurationFile.getInstance();
        itemStack = new ItemBuilder(getTag())
                .setName(configurationFile.getMessage("custom-items." + getTag() + ".name"))
                .setMaterial(Material.INK_SACK)
                .setDataValue((byte)8)
                .build();
    }

    @Override
    public ItemStack getItemStack() { return itemStack; }

    @Override
    public @Nullable String getTag() { return "neutral-fragment"; }
}
