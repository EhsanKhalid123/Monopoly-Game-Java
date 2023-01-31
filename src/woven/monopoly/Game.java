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

            // Gets the current player
            Player currentPlayer = players.get(currentPlayerIndex);

            System.out.println("It's " + currentPlayer.getName() + "'s turn!");
            System.out.println("Current Balance: $" + currentPlayer.getBalance());
            System.out.println("Current Position: " + currentPlayer.getPosition());

            System.out.println();

            // Gets the dice roll number for the current turn then removes that number from the list to get the next one
            int roll = rolls.get(0);
            rolls.remove(0);
            System.out.println(currentPlayer.getName() + " rolled number " + roll + " on the dice!");

            System.out.println();

            // Moves the player to the new position on the board
            int newPosition = (currentPlayer.getPosition() + roll) % properties.size();
            currentPlayer.setPosition(newPosition);
            System.out.println(currentPlayer.getName() + " moved " + roll + " position(s) forward!");
            System.out.println(currentPlayer.getName() + " moved to " + properties.get(newPosition).getName());

            System.out.println();

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
