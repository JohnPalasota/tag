package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.ItemComparator;
import org.improving.tag.items.UniqueItems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private final List<Item> items = new ArrayList<>();



    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getInventoryDisplay() {

        /*String inventoryItems = items.stream().sorted(new ItemComparator())
                .map(it -> it.toString()).reduce("You have these items: ", (answer, itemName) -> answer += "\n" + itemName);*/

        return items.stream().sorted(new ItemComparator()).map(i -> "\n" + i)
                .reduce("You have these items: ", (answer, itemVal) -> answer+= itemVal);
    }
}

