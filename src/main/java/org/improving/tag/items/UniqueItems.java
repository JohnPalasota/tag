package org.improving.tag.items;

import org.springframework.stereotype.Component;


public enum UniqueItems implements Item {

    THE_ONE_RING("The One Ring", "A golden ring"),
    BLUE_SHELL("Blue Shell", "A blue shell with wings"),
    EGGO_WAFFLE("EGGO Waffle", "Part of a balanced breakfast"),
    UNFORGETTABLE_MUSHROOM("Unforgettable Mushroom", "An edible toad"),
    EVERLASTING_GOBSTOPPER("Everlasting Gobstopper", "A gobstopper that never loses its flavor"),
    NOTHING("", "");
    private String description;
    private final String name;

    UniqueItems(String name, String description){
        this.name = name;
        this.description = description;
    }



    @Override
    public String toString(){
        return name + ": " + description;
    }

    @Override
    public String getName() {
        return name;
    }
}
