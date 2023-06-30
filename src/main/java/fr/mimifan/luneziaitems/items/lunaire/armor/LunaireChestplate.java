package fr.mimifan.luneziaitems.items.lunaire.armor;

import fr.mimifan.luneziaitems.api.itemfiles.LunaireConfigurationFile;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.api.items.Wearable;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class LunaireChestplate implements LuneziaItem, Wearable {

    private ItemStack itemStack;

    public LunaireChestplate(){
        itemStack = LunaireConfigurationFile.getInstance().getLuneziaItem(getTag());
    }

    @Override
    public ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public @NotNull String getTag() {
        return "lunaire-chestplate";
    }

    @Override
    public void onDamageByPlayer(EntityDamageByEntityEvent event) {

    }
}
