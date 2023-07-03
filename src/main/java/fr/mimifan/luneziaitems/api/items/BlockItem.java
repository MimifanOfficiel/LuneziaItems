package fr.mimifan.luneziaitems.api.items;

import fr.mimifan.luneziaitems.api.items.blocks.BlockBreakable;
import fr.mimifan.luneziaitems.api.items.blocks.BlockInteractable;
import fr.mimifan.luneziaitems.api.items.blocks.BlockPlaceable;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface BlockItem extends LuneziaItem, BlockBreakable, BlockPlaceable, BlockInteractable {
    Material getBlockType();

    default List<ItemStack> getDrops() {
        return List.of(this.getItemStack().clone());
    }

    default List<ItemStack> getTools() {
        return List.of();
    }
}
