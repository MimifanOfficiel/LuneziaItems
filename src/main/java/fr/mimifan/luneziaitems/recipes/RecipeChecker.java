package fr.mimifan.luneziaitems.recipes;

import fr.mimifan.luneziaitems.api.LShapedRecipe;
import fr.mimifan.luneziaitems.items.fragments.NeutralFragment;
import fr.mimifan.luneziaitems.items.fragments.SolarFragment;
import fr.mimifan.luneziaitems.managers.ItemManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RecipeChecker {

    private static RecipeChecker instance = new RecipeChecker();

    // TDDO: ça marche que pour les crafts en 3x3, il faut le fixer pour les autres dimensions
    public boolean checkRecipe(LShapedRecipe recipe, ItemStack[] contents) {
        int formeRows = 3;
        int formeCols = 3;

        int inventaireRows = this.getHauteurMax(contents);
        int inventaireCols = this.getLargeurMax(contents);

        for (int i = 0; i <= inventaireRows - formeRows; i++) {
            for (int j = 0; j <= inventaireCols - formeCols; j++) {
                boolean correspond = true;
                for (int k = 0; k < formeRows; k++) {
                    for (int l = 0; l < formeCols; l++) {
                        String[] shape = recipe.getShape();

                        if (k >= shape.length || l >= shape[k].length()) continue;

                        char itemRequis = shape[k].charAt(l);

                        int tqt = j + l + 3 * (i + k);

                        if (tqt >= contents.length) continue;

                        ItemStack itemInventaire = contents[tqt];

                        if (!itemInventaire.equals(recipe.getIngredients().get(itemRequis))) {
                            correspond = false;
                            break;
                        }
                    }
                    if (!correspond) {
                        break;
                    }
                }
                if (correspond) {
                    return true;
                }
            }
        }

        return false;
    }

    public int getLargeurMax(ItemStack[] inventaire) {
        int largeurMax = 0;

        for (int i = 0; i < inventaire.length; i += 3) {
            int largeurActuelle = 0;

            for (int j = i; j < i + 3; j++) {
                if (!inventaire[j].getType().equals(Material.AIR)) {
                    largeurActuelle++;
                }
            }

            if (largeurActuelle > largeurMax) {
                largeurMax = largeurActuelle;
            }
        }

        return largeurMax;
    }

    public int getHauteurMax(ItemStack[] inventaire) {
        int hauteurMax = 0;

        for (int i = 0; i < 3; i++) {
            int hauteurActuelle = 0;

            for (int j = i; j < inventaire.length; j += 3) {
                if (!inventaire[j].getType().equals(Material.AIR)) {
                    hauteurActuelle++;
                }
            }

            if (hauteurActuelle > hauteurMax) {
                hauteurMax = hauteurActuelle;
            }
        }

        return hauteurMax;
    }
    public static RecipeChecker getInstance() {
        return instance;
    }
}
