package fr.mimifan.luneziaitems.managers;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.api.items.Wearable;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private static PlayerManager instance = new PlayerManager();

    List<Player> players = new ArrayList<>();

    public void load(){
        Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(Main.class), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                register(player);
            }
        });
    }

    public void unload(){
        players.clear();
        for (Player player : Bukkit.getOnlinePlayers()) {
            unregister(player);
        }
    }

    public void register(Player player){
        players.add(player);
        Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(Main.class), () -> {
            for (ItemStack itemStack : player.getInventory().getArmorContents()) {
                LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(itemStack));

                if(luneziaItem == null) continue;
                if(luneziaItem instanceof Wearable) ((Wearable) luneziaItem).addEffects(player);
            }

            LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(player.getItemInHand()));

            if(luneziaItem == null) return;
            if(luneziaItem instanceof Wearable) ((Wearable) luneziaItem).removeEffects(player);
        });

    }


    public void unregister(Player player){
        Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(Main.class), () -> {
            for (ItemStack itemStack : player.getInventory().getArmorContents()) {
                LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(itemStack));

                if(luneziaItem == null) continue;
                if(luneziaItem instanceof Wearable) ((Wearable) luneziaItem).removeEffects(player);
            }

            LuneziaItem luneziaItem = ItemManager.getInstance().get(CraftItemStack.asNMSCopy(player.getItemInHand()));

            if(luneziaItem == null) return;
            if(luneziaItem instanceof Wearable) ((Wearable) luneziaItem).removeEffects(player);
        });
    }

    public static PlayerManager getInstance() {
        return instance;
    }
}
