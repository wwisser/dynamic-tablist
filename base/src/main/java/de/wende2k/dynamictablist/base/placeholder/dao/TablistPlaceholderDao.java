package de.wende2k.dynamictablist.base.placeholder.dao;

import de.wende2k.dynamictablist.base.placeholder.PlainTablistPlaceholder;

import java.util.List;

public interface TablistPlaceholderDao {

    void save(PlainTablistPlaceholder tablistPlaceholder);

    List<PlainTablistPlaceholder> loadByKeys(String... keys);

    List<PlainTablistPlaceholder> fetchAll();

}
