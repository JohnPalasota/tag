package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class SpellbookCommand implements Command{

    private InputOutput io;




public SpellbookCommand (InputOutput io) { this.io = io;}

    @Override
    public boolean isValid(String input) {
        return input.equalsIgnoreCase("spellbook");
    }

    @Override
    public void execute(String input) {
        io.displayText("Fireball: " + CastCommand.fireball + " casts remaining." + "\nFrostbolt: " + CastCommand.frostbolt + " casts remaining.");

    }
}