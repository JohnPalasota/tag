package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity( name = "location")
public class Location {
    @Id
    private int id;

    @Column( name = "Name")
    private String name = "";

    @Column( name = "Description")
    private String description = "";

    @Transient
    private List<String> tags = new ArrayList<>();

    @OneToMany( mappedBy = "origin")
    private List<Exit> exits = new ArrayList<>();

    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name = "AdversaryId")
    private Adversary adversary;

    @Transient
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;

    /*@Column (name = "AdversaryId")
    private Long adversaryId;*/

    @Column
    private Long adversaryIdDb;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public Adversary getAdversary() {
        return adversary;
    }

    public void setAdversary(Adversary adversary) {
        this.adversary = adversary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Exit> getExits() {
        return exits;
    }

    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }

    public Item openTreasureChest(){
//        if(TreasureChest.NO_TREASURE.equals(treasureChest)) {
//            throw new UnsupportedOperationException();
//        }
        Item treasure = treasureChest.getItem();
        treasureChest = TreasureChest.NO_TREASURE;
        return treasure;

    }

    public String getTreasureDescription() {
        return treasureChest.getDescription();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location location = (Location) obj;
            return this.getName().equals(location.getName());
        }
        return super.equals(obj);
    }

    /*public Long getAdversaryIdDb() {
        return adversaryIdDb;
    }

    public void setAdversaryIdDb(Long adversaryIdDb) {
        this.adversaryIdDb = adversaryIdDb;
    }*/


}

