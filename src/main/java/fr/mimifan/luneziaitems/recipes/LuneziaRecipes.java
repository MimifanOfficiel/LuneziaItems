package fr.mimifan.luneziaitems.recipes;

import fr.mimifan.luneziaitems.recipes.hydrus.tools.HydrusAxeRecipes;
import fr.mimifan.luneziaitems.recipes.hydrus.tools.HydrusHoeRecipes;
import fr.mimifan.luneziaitems.recipes.hydrus.tools.HydrusPickaxeRecipe;
import fr.mimifan.luneziaitems.recipes.hydrus.tools.HydrusShovelRecipes;

public class LuneziaRecipes {
    public static void loadAllRecipes() {

        //HYDRUS TOOLS RECIPES
        HydrusPickaxeRecipe.generateRecipe();
        HydrusShovelRecipes.generateRecipe();
        HydrusAxeRecipes.generateRecipe();
        HydrusHoeRecipes.generateRecipe();


    }
}
