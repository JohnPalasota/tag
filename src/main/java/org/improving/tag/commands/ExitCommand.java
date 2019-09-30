package org.improving.tag.commands;

import org.improving.tag.Exit;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand implements Command {
    InputOutput io;
    SaveGameFactory saveFactory;

    public ExitCommand(InputOutput io, SaveGameFactory saveFactory){
        this.io = io;
        this.saveFactory = saveFactory;
    }

    @Override
    public boolean isValid(String input, Game game) {
        return input.trim().equalsIgnoreCase("exit");
    }

    @Override
    public void execute(String input, Game game) {

       io.displayText("Goodbye.");
       saveFactory.save(game);
       Game.loop = false;



    }
}
