package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] commands;
    private InputOutput io;
    private Player p;
    private Location startingLocation;
    private List<Location> locationList = new ArrayList<>();
    private final SaveGameFactory saveFactory;
    private Adversary sauron = new Adversary();




    public Game(Command[] commands, InputOutput io, SaveGameFactory saveFactory) {
        startingLocation = buildWorld();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);
        this.saveFactory = saveFactory;


    }

    public Location getStartingLocation() {
        return startingLocation;
    }

    public Player getPlayer() {
        return p;

    }

    public Date getStartTime() {
        return startTime;
    }

    private void setStartTime(Date val) {
        startTime = val;
    }

    public Date getEndTime() {
        return endTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void run() {
        this.setStartTime(new Date());


        try{
            boolean loop = true;
            while (loop) {


                io.displayPrompt("> ");
                String input = io.receiveInput();
                Command validCommand = getValidCommand(input);
                if (null != validCommand) {
                    validCommand.execute(input, this);
//            } else if (input.equalsIgnoreCase("exit")) {
//                saveFactory.save(this);
//                io.displayText("Goodbye.");
//                loop = false;
                } else {
                    io.displayText("Huh? I don't understand.");
                }
            }

        }catch(IllegalStateException ex) {
            this.setEndTime(new Date());

        }
    }

    private Command getValidCommand(String input) {
        for (Command command : commands) {
            if (command.isValid(input, this)) {
                return command;
            }
        }
        return null;
    }

    private Location buildWorld(){
        var tdh = new Location();
        tdh.setName("The Deathly Hallows");
        this.locationList.add(tdh);
        sauron.setHitPoints(100);
        sauron.setName("Sauron");


        var td = new Location();
        td.setName("The Desert");
        this.locationList.add(td);

        var ta = new Location();
        ta.setName("The Amazon");
        this.locationList.add(ta);

        var tmcs = new Location();
        tmcs.setName("The Mac & Cheese Shop");
        this.locationList.add(tmcs);

        var apt = new Location();
        apt.setName("Airport");
        this.locationList.add(apt);

        var tmtn = new Location();
        tmtn.setName("The Mountains");
        this.locationList.add(tmtn);

        var tict = new Location();
        tict.setName("The Ice Cream Truck");
        this.locationList.add(tict);

        var mtd = new Location();
        mtd.setName("Mount Doom");
        this.locationList.add(mtd);
        mtd.setAdversary(sauron);

        var tvod = new Location();
        tvod.setName("The Volcano of Death");
        this.locationList.add(tvod);

        var mall = new Location();
        mall.setName("The Mall");
        this.locationList.add(mall);

        var reef = new Location();
        reef.setName("The Reef");
        this.locationList.add(reef);

        var tvm = new Location();
        tvm.setName("The Velvet Moose");
        this.locationList.add(tvm);

        tdh.getExits().add(new Exit("Heaven Ave", tmcs, "h", "heaven", "ave"));
        tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb", "brownie", "deathly", "The"));

        td.getExits().add(new Exit("Camel Path", ta, "cp", "camel"));
        td.getExits().add(new Exit("The Dock", apt, "dock", "the dock", "the"));
        td.getExits().add(new Exit("Rocky Road", tict, "rocky", "rocky road", "road"));

        tmcs.getExits().add(new Exit("Highway 121", ta, "121", "hwy", "highway 121", "h121"));

        tvm.getExits().add(new Exit("The Pudding Slide", apt, "the pudding", "the slide", "pudding", "slide", "the pudding slide", "pudding slide"));

        apt.getExits().add(new Exit("Flight 121", tmtn,  "flight 121", "flight121", "121"));
        apt.getExits().add(new Exit("Flight to the Mall", mall, "flight to the mall", "mall", "to mall", "flight mall"));

        tmtn.getExits().add(new Exit("Bike Trail", reef, "bike", "bike trail", "trail"));
        tmtn.getExits().add(new Exit("The Plane", ta, "plane", "the plane"));
        tmtn.getExits().add(new Exit("The Narrow Trail", mtd, "narrow", "the narrow", "the trail", "trail", "the narrow trail"));
        tmtn.getExits().add(new Exit("The Lava Flow", tvod, "lava", "the lava", "the lava flow", "the flow", "flow"));

        mtd.getExits().add(new Exit("The Cab", mall, "cab", "the cab"));
        mtd.getExits().add(new Exit("Jump into Lava", tvod, "lava", "jump lava", "jump into lava", "lava", "jump into the lava"));

        mall.getExits().add(new Exit("Path to Doom", mtd, "path", "path to", "path to doom", "path doom", "to doom", "doom"));
        mall.getExits().add(new Exit("An Escalator of Doom", tvod, "escalator", "an escalator", "escalator of doom", "an escalator of doom", "of doom"));
        mall.getExits().add(new Exit("The City Walk", reef, "city", "city walk", "the city walk", "walk", "the walk", "the city"));

        reef.getExits().add(new Exit("The Scenic Route", tvm, "scenic route", "route", "scenic", "the route", "the scenic", "the scenic route"));

        ta.getExits().add(new Exit("Amaz-ing Moose", tvm, "amaz-ing moose", "amazing moose", "moose", "amazing", "amaz-ing"));

        tvm.getExits().add(new Exit("The Front Door", ta, "front door", "the front door", "the front", "the door", "door", "front"));

        tict.getExits().add(new Exit("Magic Portal", mtd, "magic portal", "magic", "portal"));

        tmcs.getExits().add(new Exit("Paradise Rd", reef, "paradise rd", "paradise", "rd", "paradise road", "road"));
        tmcs.getExits().add(new Exit("Highway 21", tvod, "highway 21", "hwy 21", "h21", "h 21"));

        return tdh;
    }

    public Location getLocationOf(String intendedLocationName) {
        for (Location location: locationList ){
            if (intendedLocationName.equalsIgnoreCase(location.getName())){
                return location;
            }
        }
        return null;
    }
}

