package org.improving.tag;

import java.util.Dictionary;
import java.util.Hashtable;

public class SaveGameFactory {
    private final FileSystemAdapter fsa;

    public SaveGameFactory(FileSystemAdapter fsa) {
        this.fsa = fsa;
    }

    public String save(Game game) {
        var locationName = game.getPlayer().getLocation().getName();
        Dictionary<String, String> saveContents = new Hashtable<>();
        saveContents.put("location", locationName);

        var path = fsa.saveToFile(saveContents);

        return path;
    }
}
