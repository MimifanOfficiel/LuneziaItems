package fr.mimifan.luneziaitems.recipes.hydrus.tools;

import fr.mimifan.luneziaitems.items.hydrus.tools.HydrusPickaxe;
import fr.mimifan.luneziaitems.items.fragments.NeutralFragment;
import fr.mimifan.luneziaitems.items.fragments.SolarFragment;
import fr.mimifan.luneziaitems.recipes.ShapedRegister;
import org.bukkit.Material;

public class HydrusPickaxeRecipe {

    public static void generateRecipe(){
        ShapedRegister recipe = new ShapedRegister(HydrusPickaxe.item());

        recipe.shape("NSN", "SPS", "NSN");
        recipe.setIngredient('N', NeutralFragment.item());
        recipe.setIngredient('S', SolarFragment.item());
        recipe.setIngredient('P', Material.DIAMOND_PICKAXE);
        recipe.register();
    }

}
