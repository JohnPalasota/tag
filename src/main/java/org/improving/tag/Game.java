package org.improving.tag;

import org.improving.tag.commands.*;
import org.improving.tag.items.UniqueItems;
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



    public Game(Command[] commands, InputOutput io,
                SaveGameFactory saveFactory, WorldBuilder worldBuilder) {
        startingLocation = worldBuilder.buildWorld();
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

        boolean loop = true;
        try {

            while (loop) {


                io.displayPrompt("> ");
                String input = io.receiveInput();
                Command validCommand = getValidCommand(input);
                if (null != validCommand) {
                    validCommand.execute(input, this);
                } else {
                    io.displayText("Huh? I don't understand.");
                }
            }

        } catch (GameExitException ex) {
            loop = false;


        }
        this.setEndTime(new Date());
    }

    private Command getValidCommand(String input) {
        for (Command command : commands) {
            if (command.isValid(input, this)) {
                return command;
            }
        }
        return null;
    }

    public Location getLocationOf(String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }

        }
        return null;
    }





    }


