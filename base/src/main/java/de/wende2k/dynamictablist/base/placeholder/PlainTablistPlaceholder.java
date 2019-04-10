package de.wende2k.dynamictablist.base.placeholder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class PlainTablistPlaceholder implements TablistPlaceholder<String> {

    private String key;
    private String description;
    private String sampleValue;

}
