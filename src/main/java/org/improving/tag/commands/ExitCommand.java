package org.improving.tag.commands;

import org.improving.tag.*;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand extends BaseAliasedCommand {
    private final SaveGameFactory saveFactory;


    public ExitCommand(InputOutput io, SaveGameFactory saveFactory){
        super(io, "exit");
        this.saveFactory = saveFactory;
    }

    @Override
    public boolean isValid(String input, Game game) {
        return input.trim().equalsIgnoreCase("exit");
    }

    @Override
    public void childExecute(String input, Game game) {
        io.displayText("Goodbye.");
        saveFactory.save(game);

        throw new GameExitException();



    }
}
