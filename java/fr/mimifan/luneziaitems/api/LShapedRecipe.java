package fr.mimifan.luneziaitems.api;

import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.lang.reflect.Field;
import java.util.HashMap;

public class LShapedRecipe {

    private final ShapedRecipe recipe;

    private final HashMap<Character, ItemStack> ingredients = new HashMap<>();

    public LShapedRecipe(ItemStack result) {
        this.recipe = new ShapedRecipe(result);
    }

    public LShapedRecipe shape(String... args) {
        this.recipe.shape(args);
        return this;
    }

    @SuppressWarnings("unchecked")
    public void setIngredient(char symbol, ItemStack itemStack) {
        this.ingredients.put(symbol, itemStack);

        try {
            Field f = this.recipe.getClass().getDeclaredField("ingredients");
            f.setAccessible(true);

            HashMap<Character, ItemStack> i = (HashMap<Character, ItemStack>) f.get(this.recipe);

            i.put(symbol, itemStack);

            f.set(this.recipe, i);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public LShapedRecipe setIngredient(char symbol, Material material) {
        this.recipe.setIngredient(symbol, material);
        this.ingredients.put(symbol, new ItemStack(material, 1));
        return this;
    }

    public ShapedRecipe getRecipe() {return recipe;}

    public HashMap<Character, ItemStack> getIngredients() {
        return ingredients;
    }

    public String[] getShape() {
        return this.recipe.getShape();
    }
}
