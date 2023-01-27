package woven.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Game {

    static List<Player> players;
    static List<Property> properties;
    static List<Integer> rolls;
    static int currentPlayerIndex;

    public void startGame() {

        // Create a new Board object
        Board board = new Board();

        // Welcome Message
        System.out.println("Welcome to Woven Monopoly!");
        System.out.println();

        // load board from board.json and add the properties on the board to this variable
        properties = board.loadBoard();

        // load dice rolled numbers from roll_1.json and add the numbers to this variable rolls which is a list
        rolls = board.loadRolls();

        // Creates 4 players and adds them to a list called players
        players = new ArrayList<Player>();
        players.add(new Player("Peter"));
        players.add(new Player("Billy"));
        players.add(new Player("Charlotte"));
        players.add(new Player("Sweedal"));

    }
}
