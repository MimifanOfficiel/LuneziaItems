package fr.mimifan.luneziaitems.api.items;

import fr.mimifan.luneziaitems.api.LShapedRecipe;
import fr.mimifan.luneziaitems.recipes.RecipeChecker;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public interface Craftable {
    @NotNull
    LShapedRecipe getLRecipe();

    default void onCraft(CraftItemEvent event) {}

    default void prepareCraft(PrepareItemCraftEvent event) {
        ItemStack[] modifiedArray = Arrays.copyOfRange(event.getInventory().getContents(), 1, event.getInventory().getContents().length);

        if (!RecipeChecker.getInstance().checkRecipe(this.getLRecipe(), modifiedArray)) {
            event.getInventory().setResult(null);
        }
    }
}
