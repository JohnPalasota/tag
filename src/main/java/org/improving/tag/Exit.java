package org.improving.tag;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Exit{

    long id;


    private int originId;


    private int destinationId;


    private String name;


    private Location destination;


    private List<String> aliases = new ArrayList<>();


    public Exit(){ }

    public Exit(String name, Location destination){
        this.name = name;
        this.destination = destination;
    }

    public Exit(String name, Location destination, String...aliases){
        this.name = name;
        this.destination = destination;
        this.aliases.addAll(Arrays.asList(aliases));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Exit) {
            Exit exit = (Exit) obj;
            return this.getName().equals(exit.getName()) &&
                    this.getDestination().equals(exit.getDestination());
        }
        return super.equals(obj);
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }


}
