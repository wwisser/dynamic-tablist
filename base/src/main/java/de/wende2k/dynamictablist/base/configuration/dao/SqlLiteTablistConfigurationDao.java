package de.wende2k.dynamictablist.base.configuration.dao;

import de.wende2k.dynamictablist.base.configuration.TablistConfiguration;
import de.wende2k.dynamictablist.base.database.SqlLiteConnectionProvider;

import java.sql.Connection;
import java.util.List;

public class SqlLiteTablistConfigurationDao implements TablistConfigurationDao {

    private Connection connection;

    public SqlLiteTablistConfigurationDao(SqlLiteConnectionProvider connectionProvider) {
        this.connection = connectionProvider.getConnection();
    }

    @Override
    public void save(TablistConfiguration tablistConfiguration) {

    }

    @Override
    public TablistConfiguration load(String uuid) {
        return null;
    }

    @Override
    public List<TablistConfiguration> fetchAll() {
        return null;
    }

}
