package de.wende2k.dynamictablist.base.configuration.dao;

import de.wende2k.dynamictablist.base.configuration.TablistConfiguration;

import java.util.List;

public interface TablistConfigurationDao {

    void save(TablistConfiguration tablistConfiguration);

    TablistConfiguration load(String uuid);

    List<TablistConfiguration> fetchAll();

}
