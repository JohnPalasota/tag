package org.improving.tag;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of Main");
        Game game = new Game(100, 23);
        System.out.println("Declared Game");
            game.run();
        System.out.println("After run()");

        long elapsedTicks = game.getEndTime().getTime() - game.getStartTime().getTime();
        double elapsedSeconds = elapsedTicks / 1000.0;

        System.out.println("We were running for " + elapsedSeconds + "s.");
    }
}

