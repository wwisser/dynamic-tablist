package de.wende2k.dynamictablist.base;

import de.wende2k.dynamictablist.base.configuration.dao.SqlLiteTablistConfigurationDao;
import de.wende2k.dynamictablist.base.configuration.dao.TablistConfigurationDao;
import de.wende2k.dynamictablist.base.database.SqlLiteConnectionProvider;
import de.wende2k.dynamictablist.base.placeholder.dao.SqlLiteTablistPlaceholderDao;
import de.wende2k.dynamictablist.base.placeholder.dao.TablistPlaceholderDao;
import lombok.Getter;

@Getter
public class DynamicTablistBaseApi implements DynamicTablistApi {

    private static DynamicTablistBaseApi instance = new DynamicTablistBaseApi();

    private TablistConfigurationDao tablistConfigurationDao;
    private TablistPlaceholderDao tablistPlaceholderDao;

    private DynamicTablistBaseApi() {
        String filePath = ""; // TODO: add configuration for file path
        SqlLiteConnectionProvider.init(filePath);
        SqlLiteConnectionProvider connectionProvider = SqlLiteConnectionProvider.getInstance();

        this.tablistConfigurationDao = new SqlLiteTablistConfigurationDao(connectionProvider);
        this.tablistPlaceholderDao = new SqlLiteTablistPlaceholderDao(connectionProvider);
    }

    public static DynamicTablistBaseApi getInstance() {
        return DynamicTablistBaseApi.instance;
    }

}
