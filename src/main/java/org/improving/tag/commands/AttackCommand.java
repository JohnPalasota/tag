package org.improving.tag.commands;

import org.improving.tag.Adversary;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
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
        if (game.getPlayer().getLocation().getAdversary() == null){
            io.displayText("Attack what?");
            return;
        }
        Adversary adv = game.getPlayer().getLocation().getAdversary();
        if (random.nextInt(100)+1 <= 20){
            adv.setDamageTaken(adv.getDamageTaken() + 10);
            io.displayText( adv.getHitPoints() - adv.getDamageTaken() + "hp remaining for " +
                    game.getPlayer().getLocation().getAdversary().getName());
        }
        else{
            io.displayText("Your attack missed.");
        }
    }
}
