package fr.mimifan.luneziaitems.commands;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.api.configuration.ConfigurationFile;
import fr.mimifan.luneziaitems.api.configuration.YamlConfigurationFile;
import fr.mimifan.luneziaitems.api.itemfiles.HydrusConfigurationFile;
import fr.mimifan.luneziaitems.api.itemfiles.LunaireConfigurationFile;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.managers.ItemManager;
import net.md_5.bungee.api.chat.*;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLItems implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(!player.isOp()) return false;
        if (args.length > 2 || args.length < 1) return false;
        if(args.length == 1){
            if(args[0].equalsIgnoreCase("reload")) {
                ConfigurationFile.getInstance().load();
                Main.getInstance().loadConfigurations();
                Main.getInstance().loadItems();

                player.sendMessage("§7La configuration a bien été rechargée.");
                return true;
            }
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

        LuneziaItem litem = ItemManager.getInstance().get(item);

        if (litem == null) {
            for (LuneziaItem luneziaItem : ItemManager.getInstance().getLuneziaItemList()) {
                TextComponent component = new TextComponent("§7/litems §f" + luneziaItem.getTag());
                component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Clique pour te give l'item").create()));
                component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/litems " + luneziaItem.getTag()));
                player.spigot().sendMessage(component);
            }
            return;
        }

        player.getInventory().addItem(litem.getItemStack(quantity));
        player.playSound(player.getLocation(), Sound.PORTAL, 10, 10);
    }
}
