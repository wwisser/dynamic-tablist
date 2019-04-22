package de.wende2k.dynamictablist.base;

import de.wende2k.dynamictablist.base.configuration.dao.SqLiteTablistConfigurationDao;
import de.wende2k.dynamictablist.base.configuration.dao.TablistConfigurationDao;
import de.wende2k.dynamictablist.base.database.SqLiteConnectionProvider;
import de.wende2k.dynamictablist.base.placeholder.dao.SqLiteTablistPlaceholderDao;
import de.wende2k.dynamictablist.base.placeholder.dao.TablistPlaceholderDao;
import lombok.Getter;

@Getter
public class DynamicTablistBaseApi implements DynamicTablistApi {

    private static DynamicTablistBaseApi instance = new DynamicTablistBaseApi();

    private TablistConfigurationDao tablistConfigurationDao;
    private TablistPlaceholderDao tablistPlaceholderDao;

    private DynamicTablistBaseApi() {
        String filePath = ""; // TODO: add configuration for file path
        SqLiteConnectionProvider.init(filePath);
        SqLiteConnectionProvider connectionProvider = SqLiteConnectionProvider.getInstance();

        this.tablistConfigurationDao = new SqLiteTablistConfigurationDao(connectionProvider);
        this.tablistPlaceholderDao = new SqLiteTablistPlaceholderDao(connectionProvider);
    }

    public static DynamicTablistBaseApi getInstance() {
        return DynamicTablistBaseApi.instance;
    }

}
