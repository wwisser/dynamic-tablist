package de.wende2k.dynamictablist.base.database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

@Getter
public class SqLiteConnectionProvider {

    private static SqLiteConnectionProvider instance;

    private Connection connection;

    private SqLiteConnectionProvider(final String filePath) {
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
        if (SqLiteConnectionProvider.instance != null) {
            throw new IllegalArgumentException("Provider already initialized");
        }

        SqLiteConnectionProvider.instance = new SqLiteConnectionProvider(filePath);
    }

    public static SqLiteConnectionProvider getInstance() {
        return Objects.requireNonNull(
            SqLiteConnectionProvider.instance,
            "Provider not initialized yet"
        );
    }

}
