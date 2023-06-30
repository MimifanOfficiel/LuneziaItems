package fr.mimifan.luneziaitems.api.items;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LuneziaItem {
    ItemStack getItemStack();

    default ItemStack getItemStack(int amount) {
        ItemStack itemStack = this.getItemStack().clone();
        itemStack.setAmount(amount);
        return itemStack;
    }

    @NotNull
    String getTag();
}
