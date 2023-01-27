package woven.monopoly;

import java.util.List;

public class Game {

    static List<Player> players;
    static List<Property> properties;
    static List<Integer> rolls;
    static int currentPlayerIndex;

    public void startGame() {

        // Create a new Board object
        Board board = new Board();

        System.out.println("Welcome to Woven Monopoly!");
        System.out.println();

        // load board from board.json and add the properties on the board to this variable
        properties = board.loadBoard();

    }
}
