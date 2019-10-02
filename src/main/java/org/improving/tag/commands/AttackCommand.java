package org.improving.tag.commands;

import org.improving.tag.Adversary;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand implements Command {
    InputOutput io;
    Random random = new Random();
    AttackCommand(InputOutput io){
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input = input.trim();
        return input.equalsIgnoreCase("attack");

    }

    @Override
    public void execute(String input, Game game) {
        Adversary adv = game.getPlayer().getLocation().getAdversary();
        if (adv == null){
            io.displayText("Attack what?");
            return;
        }
        if (random.nextInt(100)+1 <= 20){
            adv.setDamageTaken(adv.getDamageTaken() + 10);
            if ((adv.getHitPoints() - adv.getDamageTaken()) > 0) {
                io.displayText( adv.getHitPoints() - adv.getDamageTaken() + "hp remaining for " + adv.getName());
            }
            else{
                io.displayText("" + adv.getName() + " has been defeated!");
                adv.dropItem().autoLoot();
                if (adv.dropItem() != null){
                    io.displayText("" + adv.dropItem() + " has been dropped by " + adv.getName() + "!");
                }
                game.getPlayer().getInventory().addItem(adv.dropItem());
                game.getPlayer().getLocation().setAdversary(null);

            }
        }
        else{
            io.displayText("Your attack missed.");
        }

    }


}
