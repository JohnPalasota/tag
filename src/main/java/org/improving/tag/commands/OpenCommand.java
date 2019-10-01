package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.items.Item;
import org.springframework.stereotype.Component;

@Component
public class OpenCommand extends BaseAliasedCommand {

    public OpenCommand(InputOutput io) {
        super(io, "open", "ope", "opn", "o", "loot", "loot chest", "lc");

    }

    @Override
    public void childExecute(String input, Game game) {
        var location = game.getPlayer().getLocation();
        if (location.getTreasureDescription().equals("")) {
            io.displayText("There is nothing to open.");
        } else {
            Item item = game.getPlayer().getLocation().openTreasureChest();
            io.displayText("You found: " + item);
            game.getPlayer().getInventory().addItem(item);
        }
    }
}
