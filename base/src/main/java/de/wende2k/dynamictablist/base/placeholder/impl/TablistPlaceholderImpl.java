package de.wende2k.dynamictablist.base.placeholder.impl;

import de.wende2k.dynamictablist.base.placeholder.TablistPlaceholder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class TablistPlaceholderImpl<T> implements TablistPlaceholder<T> {

    private String key;
    private String description;
    private T sampleValue;

}
