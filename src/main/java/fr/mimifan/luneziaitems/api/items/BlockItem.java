package fr.mimifan.luneziaitems.api.items;

import fr.mimifan.luneziaitems.api.items.blocks.BlockBreakable;
import fr.mimifan.luneziaitems.api.items.blocks.BlockPlaceable;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public interface BlockItem extends LuneziaItem, BlockBreakable, BlockPlaceable {
    Material getBlockType();

    default ItemStack getDrop() {
        return this.getItemStack().clone();
    }
}
