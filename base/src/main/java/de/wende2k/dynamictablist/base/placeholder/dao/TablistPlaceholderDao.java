package de.wende2k.dynamictablist.base.placeholder.dao;

import de.wende2k.dynamictablist.base.placeholder.TablistPlaceholder;

import java.util.List;

public interface TablistPlaceholderDao {

    void save(TablistPlaceholder<String> tablistPlaceholder);

    List<TablistPlaceholder<String>> loadByKeys(String... keys);

    List<TablistPlaceholder<String>> fetchAll();

}
