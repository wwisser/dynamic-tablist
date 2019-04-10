package de.wende2k.dynamictablist.plugin.placeholder.predefined;

import de.wende2k.dynamictablist.base.placeholder.TablistPlaceholder;
import org.bukkit.Bukkit;

public class MaxPlayersTablistPlaceholder implements TablistPlaceholder<Integer> {

    @Override
    public String getKey() {
        return "online";
    }

    @Override
    public String getDescription() {
        return "Displays the max user slots.";
    }

    @Override
    public Integer getSampleValue() {
        return 100;
    }

    @Override
    public Integer updateValue() {
        return Bukkit.getMaxPlayers();
    }

}
