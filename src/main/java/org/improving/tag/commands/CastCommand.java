package org.improving.tag.commands;


import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class CastCommand implements Command{
    static int fireball = 2;
    static int frostbolt = 2;
    private InputOutput io;

    public int getFireball(){
        return fireball;
    }

    public int getFrostbolt(){
        return frostbolt;
    }

    public CastCommand(InputOutput io){this.io = io;}

    @Override
    public boolean isValid(String input) {
        if (input == null) return true;
        input.trim();
        var parts = input.split(" ");
        if (parts.length == 1) return false;
        if (parts[1].equalsIgnoreCase("fireball")) return true;
        else if (parts[1].equalsIgnoreCase("frostbolt")) return true;
        else return false;
    }

    @Override
    public void execute(String input) {
        var parts = input.split(" ");
        if(parts[1].equalsIgnoreCase("fireball") && fireball!=0){
        io.displayText("You cast fireball. Your opponent is engulfed in flames.");
        fireball--;
        }
        else if(parts[1].equalsIgnoreCase("frostbolt") && frostbolt!=0){
            io.displayText("You cast frostbolt. Brrrgh!");
            frostbolt--;
        }
        else io.displayText("You move your hands around weirdly... Nothing happens.");


    }


}
