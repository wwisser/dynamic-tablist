package de.wende2k.dynamictablist.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
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
