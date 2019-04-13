package de.wende2k.dynamictablist.base.configuration.dao;

import de.wende2k.dynamictablist.base.configuration.TablistConfiguration;
import de.wende2k.dynamictablist.base.database.SqlLiteConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlLiteTablistConfigurationDao implements TablistConfigurationDao {

    private static final String TABLE_NAME = "tablist_configs";

    private Connection connection;

    public SqlLiteTablistConfigurationDao(SqlLiteConnectionProvider connectionProvider) {
        this.connection = connectionProvider.getConnection();
    }

    @Override
    public void save(TablistConfiguration tablistConfiguration) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                "INSERT OR REPLACE INTO " + TABLE_NAME
                    + " (owner, header, footer, created, last_edited) VALUES (?, ?, ?, ?, ?)"
            );

            preparedStatement.setString(1, tablistConfiguration.getOwner());
            preparedStatement.setString(2, tablistConfiguration.getHeader());
            preparedStatement.setString(3, tablistConfiguration.getFooter());
            preparedStatement.setLong(4, tablistConfiguration.getCreated());
            preparedStatement.setLong(5, tablistConfiguration.getLastEdited());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TablistConfiguration load(String uuid) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                "SELECT * FROM " + TABLE_NAME + " WHERE owner = ?"
            );

            preparedStatement.setString(1, uuid);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }

                return this.decodeResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TablistConfiguration> fetchAll() {
        try {
            List<TablistConfiguration> results = new ArrayList<>();
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM " + TABLE_NAME);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    results.add(this.decodeResultSet(resultSet));
                }
            }

            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private TablistConfiguration decodeResultSet(ResultSet resultSet) throws SQLException {
        return new TablistConfiguration(
            resultSet.getString(1),
            resultSet.getString(2),
            resultSet.getString(3),
            resultSet.getLong(4),
            resultSet.getLong(5)
        );
    }

}
