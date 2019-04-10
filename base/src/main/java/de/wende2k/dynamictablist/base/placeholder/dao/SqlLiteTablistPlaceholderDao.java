package de.wende2k.dynamictablist.base.placeholder.dao;

import de.wende2k.dynamictablist.base.database.SqlLiteConnectionProvider;
import de.wende2k.dynamictablist.base.placeholder.PlainTablistPlaceholder;

import java.sql.Connection;
import java.util.List;

public class SqlLiteTablistPlaceholderDao implements TablistPlaceholderDao {

    private Connection connection;

    public SqlLiteTablistPlaceholderDao(SqlLiteConnectionProvider connectionProvider) {
        this.connection = connectionProvider.getConnection();
    }

    @Override
    public void save(PlainTablistPlaceholder tablistPlaceholder) {

    }

    @Override
    public List<PlainTablistPlaceholder> loadByKeys(String... keys) {
        return null;
    }

    @Override
    public List<PlainTablistPlaceholder> fetchAll() {
        return null;
    }

}
