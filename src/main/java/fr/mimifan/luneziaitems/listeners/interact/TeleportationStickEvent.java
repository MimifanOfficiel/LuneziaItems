package fr.mimifan.luneziaitems.listeners.interact;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.items.misc.TeleportationStick;
import fr.mimifan.luneziaitems.utils.CustomStrings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class TeleportationStickEvent {

    public static void use(final PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(isInUnallowedChunk(player, event.getClickedBlock().getLocation())) return;
            if(!TeleportationStick.getCooldown().containsKey(player)){
                setTP_Point(player, event.getClickedBlock().getLocation());
            } else {
                long timeElapsed = System.currentTimeMillis() - TeleportationStick.getCooldown().get(player);
                if(timeElapsed >= (long) TeleportationStick.cooldown_time * 1000){
                    setTP_Point(player, event.getClickedBlock().getLocation());
                } else {
                    player.sendMessage(CustomStrings.replaceString("customItems.tp_stick.wait-before-moving").replace("%time%", "" + ((((long) TeleportationStick.cooldown_time*1000)-timeElapsed)/1000)));
                }
            }
        } else if(event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(isInUnallowedChunk(player, event.getPlayer().getLocation())) return;
            if(TeleportationStick.getTp_point().containsKey(player)){
                player.teleport(TeleportationStick.getTp_point().get(player));
                TeleportationStick.getTp_point().remove(player);
            } else player.sendMessage(CustomStrings.replaceString("customItems.tp_stick.no-point"));
        }
    }

    public static boolean isInUnallowedChunk(final Player player, final Location loc){
        if(Board.getInstance().getFactionAt(new FLocation(loc)).isSafeZone() || Board.getInstance().getFactionAt(new FLocation(loc)).isWarZone()){
            player.sendMessage(CustomStrings.replaceString("customItems.cant-here"));
            return true;
        }
        return false;
    }

    public static void setTP_Point(final Player player, Location loc){
        loc.setPitch((float)0);
        loc.setY(loc.getY()+1);
        TeleportationStick.getTp_point().put(player, loc);
        TeleportationStick.getCooldown().put(player, System.currentTimeMillis());

        player.sendMessage(CustomStrings.replaceString("customItems.tp_stick.point-placed"));
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            long timeElapsed = System.currentTimeMillis() - TeleportationStick.getCooldown().get(player);
            if(!TeleportationStick.getTp_point().containsKey(player)) return;
            if(timeElapsed >= (long) TeleportationStick.cooldown_time * 1000){
                TeleportationStick.getTp_point().remove(player);
                TeleportationStick.getCooldown().remove(player);
                player.sendMessage(CustomStrings.replaceString("customItems.tp_stick.point-removed"));
            }
        }, 2420L);
    }

}
