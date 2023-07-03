package fr.mimifan.luneziaitems.blocks;

import fr.mimifan.luneziaitems.api.items.BlockItem;
import fr.mimifan.luneziaitems.items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TestBlock implements BlockItem {

    private ItemStack itemstack;

    public TestBlock() {
        this.itemstack = new ItemBuilder(this.getTag())
                .setMaterial(Material.DIAMOND)
                .setName("§asuper dimaond test")
                .build();
    }

    @Override
    public Material getBlockType() {
        return Material.COAL_BLOCK;
    }

    @Override
    public void onBlockBreak(BlockBreakEvent e) {

    }

    @Override
    public void onBlockPlace(PlayerInteractEvent e) {

    }

    @Override
    public ItemStack getItemStack() {
        return this.itemstack;
    }

    @Override
    public @NotNull String getTag() {
        return "test";
    }
}
