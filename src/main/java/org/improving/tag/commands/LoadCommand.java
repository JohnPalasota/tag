package org.improving.tag.commands;

import org.improving.tag.*;
import org.springframework.stereotype.Component;

@Component
public class LoadCommand implements Command {
    private InputOutput io;
    private String path = "thisisafakepath";
    private SaveGameFactory factory;

    public LoadCommand (InputOutput io, SaveGameFactory factory){
        this.io = io;
        this.factory = factory;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if(parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("load");
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var parts = input.split( " ");
        this.path = parts[1];
        factory.load(path, game);
        io.displayText("Game loaded");



    }
}
