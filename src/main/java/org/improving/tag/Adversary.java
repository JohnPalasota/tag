package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import javax.persistence.*;
import java.util.Arrays;

@Entity( name = "adversary")
public class Adversary {
    @Id
    long id;

    @Column( name = "Name")
    private String name;

    @Column( name = "HitPoints")
    private int hitPoints;

    @Column( name = "DamageTaken")
    private int damageTaken;

    @Column( name = "AttackDamage")
    private int attackDamage;

    /*@Column(name = "dropItemDb")
    private String dropItemDb;*/

    @Column( name = "DropItem")
    private  UniqueItems item ;

    /*@Column( name = "ForExercise")
    @Convert
    private UniqueItems forExercise;*/


    public Adversary() {
    }

    public Adversary(String name, int hitPoints, UniqueItems item){
        this.name = name;
        this.hitPoints = hitPoints;
        this.item = item;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public Item dropItem(){
        return item;

    }



    public Item getItem() {
        return item;
    }

    public void setItem(UniqueItems item) {
        this.item = item;
    }

    /*public String getDropItemDb() {
        return dropItemDb;
    }

    public void setDropItemDb(String dropItemDb) {
        this.dropItemDb = dropItemDb;
    }*/

    @PostLoad
    public void postLoad(){
        System.out.println("item is " + item);
        }
    }


