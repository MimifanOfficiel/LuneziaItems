package fr.mimifan.luneziaitems.managers;

import fr.mimifan.luneziaitems.Main;
import fr.mimifan.luneziaitems.api.items.BlockItem;
import fr.mimifan.luneziaitems.api.items.Craftable;
import fr.mimifan.luneziaitems.api.items.LuneziaItem;
import fr.mimifan.luneziaitems.blocks.StorageManager;
import fr.mimifan.luneziaitems.listeners.*;
import net.minecraft.server.v1_8_R3.Item;
import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static final String LUNEZIA_ITEM_TAG = "lunezia-item";

    public static final String LUNEZIA_BLOCK_TAG = "lunezia-block";

    private static final ItemManager instance = new ItemManager();

    private final List<LuneziaItem> luneziaItemList = new ArrayList<>();


    public void load(){
        PluginManager pluginManager = Main.getInstance().getServer().getPluginManager();

        pluginManager.registerEvents(new PlaceBlockListener(), Main.getInstance());
        pluginManager.registerEvents(new MiningListener(), Main.getInstance());
        pluginManager.registerEvents(new PlayersListener(), Main.getInstance());
        pluginManager.registerEvents(new ItemsListener(), Main.getInstance());
        pluginManager.registerEvents(new PlayerFightingListener(), Main.getInstance());

        pluginManager.registerEvents(new InventoryClickListener(), Main.getInstance());
        pluginManager.registerEvents(new InventoryCloseListener(), Main.getInstance());

        for (LuneziaItem luneziaItem : this.luneziaItemList) {
            if (luneziaItem instanceof Craftable) {
                Bukkit.addRecipe(((Craftable) luneziaItem).getLRecipe().getRecipe());
            }
        }
    }

    public void unload(){
        this.luneziaItemList.clear();
    }

    public void register(List<LuneziaItem> items) {
        this.luneziaItemList.addAll(items);
    }

    public void register(LuneziaItem item){
        this.luneziaItemList.add(item);
    }

    public void unregister(List<Item> items){
        this.luneziaItemList.removeAll(items);
    }

    public void unregister(LuneziaItem item){
        this.luneziaItemList.remove(item);
    }

    public List<LuneziaItem> getLuneziaItemList(){ return this.luneziaItemList; }

    @NotNull
    public LuneziaItem get(Class<?> itemClass) {
        for (LuneziaItem luneziaItem : this.luneziaItemList) {
            if (luneziaItem.getClass().equals(itemClass)) return luneziaItem;
        }

        throw new IllegalArgumentException();
    }

    @Nullable
    public LuneziaItem get(@Nullable ItemStack NMSItem) {
        if (NMSItem == null) return null;

        NBTTagCompound base = NMSItem.getTag();

        if (base == null || base.isEmpty()) return null;

        String name = base.getString(ItemManager.LUNEZIA_ITEM_TAG);

        if (name == null || name.trim().isEmpty()) return null;


        for (LuneziaItem luneziaItem : luneziaItemList) {
            if (name.equals(luneziaItem.getTag())) {
                return luneziaItem;
            }
        }

        return null;
    }

    @Nullable
    public LuneziaItem get(String tag) {
        return this.luneziaItemList.stream().filter(item -> item.getTag().equals(tag)).findFirst().orElse(null);
    }

    public BlockItem get(Block block) {
        for (LuneziaItem luneziaItem : this.luneziaItemList) {
            if (luneziaItem instanceof BlockItem blockItem) {
                if (StorageManager.getInstance().has(block, blockItem.getTag())) {
                    return blockItem;
                }
            }
        }

        return null;
    }

    public static ItemManager getInstance() {
        return instance;
    }
}
