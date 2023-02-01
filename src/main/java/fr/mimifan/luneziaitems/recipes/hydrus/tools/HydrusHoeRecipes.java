package fr.mimifan.luneziaitems.recipes.hydrus.tools;

import fr.mimifan.luneziaitems.items.fragments.NeutralFragment;
import fr.mimifan.luneziaitems.items.fragments.SolarFragment;
import fr.mimifan.luneziaitems.items.hydrus.tools.HydrusHoe;
import fr.mimifan.luneziaitems.recipes.ShapedRegister;
import org.bukkit.Material;

public class HydrusHoeRecipes {

    public static void generateRecipe(){
        ShapedRegister recipe = new ShapedRegister(HydrusHoe.item());

        recipe.shape("NSN", "SPS", "NSN");
        recipe.setIngredient('N', NeutralFragment.item());
        recipe.setIngredient('S', SolarFragment.item());
        recipe.setIngredient('P', Material.DIAMOND_HOE);
        recipe.register();
    }

}
