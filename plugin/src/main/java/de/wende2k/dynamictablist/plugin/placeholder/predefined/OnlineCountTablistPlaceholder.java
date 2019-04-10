package de.wende2k.dynamictablist.plugin.placeholder.predefined;

import de.wende2k.dynamictablist.base.placeholder.UpdatableTablistPlaceholder;
import org.bukkit.Bukkit;

import java.util.concurrent.ThreadLocalRandom;

public class OnlineCountTablistPlaceholder implements UpdatableTablistPlaceholder<Integer> {

    @Override
    public String getKey() {
        return "online";
    }

    @Override
    public String getDescription() {
        return "Displays the current user count.";
    }

    @Override
    public Integer getSampleValue() {
        return ThreadLocalRandom.current().nextInt(100);
    }

    @Override
    public Integer updateValue() {
        return Bukkit.getOnlinePlayers().size();
    }

}
