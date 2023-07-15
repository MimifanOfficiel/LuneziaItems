package fr.mimifan.luneziaitems.items.hydrus.mining;

import fr.mimifan.luneziaitems.api.LShapedRecipe;
import fr.mimifan.luneziaitems.api.itemfiles.HydrusConfigurationFile;
import fr.mimifan.luneziaitems.api.items.Craftable;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.api.items.Mining;
import fr.mimifan.luneziaitems.items.ItemBuilder;
import fr.mimifan.luneziaitems.items.fragments.NeutralFragment;
import fr.mimifan.luneziaitems.items.fragments.SolarFragment;
import fr.mimifan.luneziaitems.managers.ItemManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HydrusHoe implements LuneziaItem, Mining, Craftable {

    private ItemStack itemStack;

    public HydrusHoe(){
        itemStack = HydrusConfigurationFile.getInstance().getLuneziaItem(getTag());
    }


    @Override
    public ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public @Nullable String getTag() {
        return "hydrus-hoe";
    }

    @Override
    public void onNaturalBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Location loc = block.getLocation();

        switch (block.getType()) {
            case CROPS, POTATO, CARROT, WHEAT, BROWN_MUSHROOM, RED_MUSHROOM -> {
                if (block.getData() == (byte) 7) {
                    for (ItemStack item : block.getDrops()) {
                        loc.getWorld().dropItemNaturally(loc, item);
                    }
                }
            }
        }
    }

    @Override
    public @NotNull LShapedRecipe getLRecipe() {
        LShapedRecipe recipe = new LShapedRecipe(getItemStack());

        recipe.shape("NSN", "SPS", "NSN");
        recipe.setIngredient('N', ItemManager.getInstance().get(NeutralFragment.class).getItemStack());
        recipe.setIngredient('S', ItemManager.getInstance().get(SolarFragment.class).getItemStack());
        recipe.setIngredient('P', Material.DIAMOND_HOE);

        return recipe;
    }

}
