package org.improving.tag.items;

import org.springframework.stereotype.Component;


public enum UniqueItems implements Item {

    THE_ONE_RING("A golden ring"),
    BLUE_SHELL("A blue shell with wings"),
    NOTHING("");
    private String description;

    UniqueItems(String description){
        this.description = description;
    }



    @Override
    public String toString(){
        return description;
    }
}
