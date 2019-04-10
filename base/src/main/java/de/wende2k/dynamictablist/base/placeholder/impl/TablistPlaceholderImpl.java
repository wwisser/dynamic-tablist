package de.wende2k.dynamictablist.base.placeholder.impl;

import de.wende2k.dynamictablist.base.placeholder.TablistPlaceholder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class TablistPlaceholderImpl implements TablistPlaceholder<String> {

    private String key;
    private String description;
    private String sampleValue;

}