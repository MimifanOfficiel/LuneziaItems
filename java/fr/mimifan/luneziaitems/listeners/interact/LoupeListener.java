package fr.mimifan.luneziaitems.listeners.interact;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class LoupeListener {

    public static void use(PlayerInteractEvent event){
        event.setCancelled(true);
        Player player = event.getPlayer();
        if(!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if(!(event.getClickedBlock().getType() == Material.CHEST)) return;
        Faction locFac= Board.getInstance().getFactionAt(new FLocation(event.getClickedBlock().getLocation()));
        Faction pFac = FPlayers.getInstance().getByPlayer(player).getFaction();
        if(locFac.getRelationTo(pFac).isNeutral() || locFac.getRelationTo(pFac).isEnemy() || pFac == locFac) {
            final Inventory chest = ((Chest) event.getClickedBlock().getState()).getInventory();
            Inventory chestView = Bukkit.createInventory(null, chest.getSize(), "§eLoupe");
            chestView.setContents(chest.getContents());
            player.openInventory(chestView);
        }

    }

}
