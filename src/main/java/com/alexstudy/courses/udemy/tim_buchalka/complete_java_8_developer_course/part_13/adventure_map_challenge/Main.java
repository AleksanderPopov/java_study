package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_13.adventure_map_challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();
    private static Map<String, String> vocabulary = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Change the program to allow players to type full words, or phrases, then move to the
        // correct location based upon their input.
        // The player should be able to type commands such as "Go West", "run South", or just "East"
        // and the program will move to the appropriate location if there is one.  As at present, an
        // attempt to move in an invalid direction should print a message and remain in the same place.
        //
        // Single letter commands (N, W, S, E, Q) should still be available.
        fillContent();

        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) break;

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet())
                System.out.print(exit + ", ");
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            String[] words = direction.split(" ");

            //North, East, West, South
            if (words.length == 1 && vocabulary.containsKey(direction.toUpperCase())) {
                direction = vocabulary.get(direction.toUpperCase());
            // run East, go West, West
            } else if (words.length > 1) {
                if ((words[0].equalsIgnoreCase("run") || words[0].equalsIgnoreCase("go"))
                        && vocabulary.containsKey(words[1])) {
                    direction = vocabulary.get(words[1]);
                } else System.out.println("You cant type first word '" + words[0] + "', only 'run' or 'go'");
            }

            if(exits.containsKey(direction)) loc = exits.get(direction);
            else System.out.println("You cannot go in that direction");
        }
    }

    private static void fillContent() {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
    }
}
