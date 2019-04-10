package de.wende2k.dynamictablist.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class TablistPlaceholder {

    private String key;
    @Setter private String value;
    private String sampleValue;
    private String description;

}
