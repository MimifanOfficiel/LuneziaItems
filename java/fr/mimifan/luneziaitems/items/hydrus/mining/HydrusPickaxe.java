package fr.mimifan.luneziaitems.items.hydrus.mining;

import fr.mimifan.luneziaitems.api.LShapedRecipe;
import fr.mimifan.luneziaitems.api.itemfiles.HydrusConfigurationFile;
import fr.mimifan.luneziaitems.api.items.Craftable;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.api.items.Mining;
import fr.mimifan.luneziaitems.items.fragments.NeutralFragment;
import fr.mimifan.luneziaitems.items.fragments.SolarFragment;
import fr.mimifan.luneziaitems.managers.ItemManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HydrusPickaxe implements LuneziaItem, Mining, Craftable {

    private ItemStack itemStack;

    public HydrusPickaxe(){
        itemStack = HydrusConfigurationFile.getInstance().getLuneziaItem(getTag());
    }

    @Override
    public ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public @Nullable String getTag() {
        return "hydrus-pickaxe";
    }

    @Override
    public void onNaturalBlockBreak(BlockBreakEvent event) {
        final Block block = event.getBlock();
        Location loc = block.getLocation();
        switch (block.getType()) {
            case REDSTONE_ORE, IRON_ORE, OBSIDIAN, LAPIS_ORE, GOLD_ORE, DIAMOND_ORE -> {
                loc.getWorld().dropItemNaturally(loc, new ItemStack(block.getType()));
            }
        }
    }

    @Override
    public @NotNull LShapedRecipe getLRecipe() {
        LShapedRecipe recipe = new LShapedRecipe(getItemStack());

        recipe.shape("NSN", "SPS", "NSN");

        recipe.setIngredient('N', ItemManager.getInstance().get(NeutralFragment.class).getItemStack());
        recipe.setIngredient('S', ItemManager.getInstance().get(SolarFragment.class).getItemStack());
        recipe.setIngredient('P', Material.DIAMOND_PICKAXE);

        return recipe;
    }

}
