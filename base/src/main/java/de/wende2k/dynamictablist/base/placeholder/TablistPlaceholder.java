package de.wende2k.dynamictablist.base.placeholder;

public interface TablistPlaceholder<T> {

    String getKey();

    String getDescription();

    T getSampleValue();

}
