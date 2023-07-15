package fr.mimifan.luneziaitems.api.items;

import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface Fighting {

    void onDamageToPlayer(EntityDamageByEntityEvent event);

}
