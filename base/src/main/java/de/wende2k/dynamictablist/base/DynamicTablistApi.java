package de.wende2k.dynamictablist.base;

import de.wende2k.dynamictablist.base.configuration.dao.TablistConfigurationDao;
import de.wende2k.dynamictablist.base.placeholder.dao.TablistPlaceholderDao;

public interface DynamicTablistApi {

    TablistConfigurationDao getTablistConfigurationDao();

    TablistPlaceholderDao getTablistPlaceholderDao();

}
