package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

public class Adversary {
    private InputOutput io;
    private String name;
    private int hitPoints;
    private int damageTaken;
    private int attackDamage;
    private final Item item;
    private static final Adversary NO_ADVERSARY = new Adversary("", 0, UniqueItems.NOTHING);


    public Adversary(String name, int hitPoints, Item item){
        this.name = name;
        this.hitPoints = hitPoints;
        this.item = item;
    }
    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getHitPoints() {
        return hitPoints;
    }

//    public void setHitPoints(int hitPoints) {
//        this.hitPoints = hitPoints;
//    }

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

    public void killAdversary(Adversary adversary){

    }
}
