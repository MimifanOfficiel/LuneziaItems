package fr.mimifan.luneziaitems.commands;

import fr.mimifan.luneziaitems.items.fragments.NeutralFragment;
import fr.mimifan.luneziaitems.items.fragments.SolarFragment;
import fr.mimifan.luneziaitems.items.hydrus.tools.HydrusAxe;
import fr.mimifan.luneziaitems.items.hydrus.tools.HydrusHoe;
import fr.mimifan.luneziaitems.items.hydrus.tools.HydrusPickaxe;
import fr.mimifan.luneziaitems.items.hydrus.tools.HydrusShovel;
import fr.mimifan.luneziaitems.items.misc.TeleportationStick;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandlItems implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(!player.isOp()) return false;
        if (args.length > 2 || args.length < 1) return false;
        if(args.length == 1){
            execute(player, args[0], 1);
        } else if(args.length == 2) {
            try {
                execute(player, args[0], Integer.parseInt(args[1]));
            } catch (NumberFormatException exception) {
                execute(player, args[0], 1);
            }
        }
        return false;
    }

    public static final void execute(final Player player, String item, int quantity){
        if(quantity > 64) quantity = 64;
        switch (item){
            case "hydrus_pickaxe":
                player.getInventory().addItem(HydrusPickaxe.item(quantity));
                break;
            case "hydrus_axe":
                player.getInventory().addItem(HydrusAxe.item(quantity));
                break;
            case "hydrus_hoe":
                player.getInventory().addItem(HydrusHoe.item(quantity));
                break;
            case "hydrus_shovel":
                player.getInventory().addItem(HydrusShovel.item(quantity));
                break;
            case "tp_stick":
                player.getInventory().addItem(TeleportationStick.item(quantity));
                break;
            case "neutral_fragment":
                player.getInventory().addItem(NeutralFragment.item(quantity));
                break;
            case "solar_fragment":
                player.getInventory().addItem(SolarFragment.item(quantity));
                break;
        }
    }
}
