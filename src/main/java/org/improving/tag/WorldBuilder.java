package org.improving.tag;

import org.improving.tag.database.ExitsDAO;
import org.improving.tag.database.LocationDAO;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorldBuilder {
    private List<Location> locationList = new ArrayList<>();

    private final LocationDAO locationDAO;
    private final ExitsDAO exitsDAO;

    private Adversary sauron = new Adversary("Sauron", 10, UniqueItems.NOTHING);
    private Adversary rat = new Adversary("Rat", 20, UniqueItems.BLUE_SHELL);

    public WorldBuilder(LocationDAO locationDAO, ExitsDAO exitsDAO) {
        this.locationDAO = locationDAO;
        this.exitsDAO = exitsDAO;
    }

    public Location buildWorld() {
        try {
            List<Location> locations = locationDAO.findAll();
//            List<Exit> exits = exitsDAO.findExitsByOriginId();
//            for (var location : locations) {
//                List<Exit> exits = exitsDAO.findExitsByOriginId((location.getId()));
//                exits.forEach(( exit -> {
//                    Location destination = locations.stream()
//                            .filter(locat -> locat.getId() == exit.getDestinationId())
//                            .findFirst()
//                            .orElse(null);
//                    exit.setDestination(destination);
//                    location.getExits().add(exit);
//                }));
//            }
//
//
 //   System.out.println("Size of locations: " + locations.size());
            locationList = locations;
            return locationList.get(2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }


    public List<Location> getLocationList() {
        return locationList;
    }
}
