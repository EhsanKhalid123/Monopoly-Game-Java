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
        rolls = board.loadRolls("rolls_1.json");

        // Creates 4 players and adds them to a list called players
        players = new ArrayList<>();
        players.add(new Player("Peter"));
        players.add(new Player("Billy"));
        players.add(new Player("Charlotte"));
        players.add(new Player("Sweedal"));

//        // Sets the initial balance for each player
//        for (Player player : players) {
//            player.setBalance(16);
//        }

        // currentPlayerIndex is used to keep track of the current player's turn
        currentPlayerIndex = 0;

        // This loop will continue until one of the players is bankrupt
        while (!isAnyPlayerBankrupt(players)) {

        }
    }

    private static boolean isAnyPlayerBankrupt(List<Player> players) {
        for (Player player : players) {
            if (player.isBankrupt()) {
                return true;
            }
        }
        return false;
    }
}
