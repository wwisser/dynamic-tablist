package de.wende2k.dynamictablist.base.placeholder.dao;

import de.wende2k.dynamictablist.base.database.SqlLiteConnectionProvider;
import de.wende2k.dynamictablist.base.placeholder.PlainTablistPlaceholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SqlLiteTablistPlaceholderDao implements TablistPlaceholderDao {

    private static final String TABLE_NAME = "tablist_placeholders";

    private Connection connection;

    public SqlLiteTablistPlaceholderDao(SqlLiteConnectionProvider connectionProvider) {
        this.connection = connectionProvider.getConnection();
    }

    @Override
    public void save(PlainTablistPlaceholder tablistPlaceholder) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                "INSERT OR REPLACE INTO " + TABLE_NAME
                    + " (key, description, sample_value) VALUES (?, ?, ?)"
            );

            preparedStatement.setString(1, tablistPlaceholder.getKey());
            preparedStatement.setString(2, tablistPlaceholder.getDescription());
            preparedStatement.setString(3, tablistPlaceholder.getSampleValue());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PlainTablistPlaceholder> loadByKeys(String... keys) {
        try {
            List<PlainTablistPlaceholder> results = new ArrayList<>();
            String keyStatement = Arrays.stream(keys).map(key -> "?").collect(Collectors.joining(","));
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                "SELECT * FROM " + TABLE_NAME + " WHERE key IN (" + keyStatement + ")"
            );

            int index = 1;
            for (String key : keys) {
                preparedStatement.setString(index++, key);
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                results.add(this.decodeResultSet(resultSet));
            }

            resultSet.close();
            preparedStatement.close();

            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PlainTablistPlaceholder> fetchAll() {
        try {
            List<PlainTablistPlaceholder> results = new ArrayList<>();
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM " + TABLE_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                results.add(this.decodeResultSet(resultSet));
            }

            resultSet.close();
            preparedStatement.close();

            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PlainTablistPlaceholder decodeResultSet(ResultSet resultSet) throws SQLException {
        return new PlainTablistPlaceholder(
            resultSet.getString(1),
            resultSet.getString(2),
            resultSet.getString(3)
        );
    }

}
