package de.wende2k.dynamictablist.base.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class TablistConfiguration {

    /**
     * Holds the owner as {@link java.util.UUID} string.
     */
    private String owner;
    private List<String> header;
    private List<String> footer;
    private long created;
    /**
     * Equals {@link TablistConfiguration#created} if never edited.
     */
    private long lastEdited;

}
