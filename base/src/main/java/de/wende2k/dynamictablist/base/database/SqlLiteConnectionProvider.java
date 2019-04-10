package de.wende2k.dynamictablist.base.database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

@Getter
public class SqlLiteConnectionProvider {

    private static SqlLiteConnectionProvider instance;

    private Connection connection;

    private SqlLiteConnectionProvider(final String filePath) {
        try {
            this.connection = DriverManager.getConnection(
                "jdbc:sqlite:"
                    + filePath
                    + "/dynamic_tablist_storage.db"
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void init(final String filePath) {
        if (SqlLiteConnectionProvider.instance != null) {
            throw new IllegalArgumentException("Provider already initialized");
        }

        SqlLiteConnectionProvider.instance = new SqlLiteConnectionProvider(filePath);
    }

    public static SqlLiteConnectionProvider getInstance() {
        return Objects.requireNonNull(
            SqlLiteConnectionProvider.instance,
            "Provider not initialized yet"
        );
    }

}
