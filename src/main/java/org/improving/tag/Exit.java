package org.improving.tag;

import org.improving.tag.database.ListOfStrings;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity( name = "exits")
public class Exit{

    @Id
    long id;

    /*@Column( name = "Aliases")
    private ListO aliasesDb;*/


    @ManyToOne
    @JoinColumn( name = "OriginId")
    private Location origin;


    //private int destinationId;

    @Column( name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn( name = "DestinationId")
    private Location destination;

    @Column (name = "Aliases")
    private ListOfStrings aliases = new ListOfStrings();


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

//    public int getDestinationId() {
//        return destinationId;
//    }
//
//    public void setDestinationId(int destinationId) {
//        this.destinationId = destinationId;
//    }

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



    @PostLoad
    public void postLoad(){
        System.out.println("Your aliases are " + aliases);

    }

}
