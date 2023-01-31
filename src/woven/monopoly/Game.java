package woven.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Game {

    static List<Player> players;
    static List<Property> properties;
    static List<Integer> rolls;
    static int currentPlayerIndex;

    public void startGame(String diceRollFilePath) {

        // Create a new Board object
        Board board = new Board();

        // Welcome Message
        System.out.println("Welcome to Woven Monopoly!");
        System.out.println();

        // load board from board.json and add the properties on the board to this variable
        properties = board.loadBoard();

        // load dice rolled numbers from roll_1.json and add the numbers to this variable rolls which is a list
        rolls = board.loadRolls(diceRollFilePath);

        // Creates 4 players and adds them to a list called players
        players = new ArrayList<>();
        players.add(new Player("Peter"));
        players.add(new Player("Billy"));
        players.add(new Player("Charlotte"));
        players.add(new Player("Sweedal"));

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
            currentPlayer.setPreviousPosition(currentPlayer.getPosition());
            currentPlayer.setPosition(newPosition);
            System.out.println(currentPlayer.getName() + " moved " + roll + " position(s) forward!");
            System.out.println(currentPlayer.getName() + " moved to " + properties.get(newPosition).getName());

            System.out.println();

            // If the player passes GO, they receive $1
            if (currentPlayer.getPosition() < currentPlayer.getPreviousPosition()) {
                currentPlayer.setBalance(currentPlayer.getBalance() + 1);
                System.out.println(currentPlayer.getName() + " received $1 for passing GO");
                System.out.println("Current Balance: $" + currentPlayer.getBalance());
                System.out.println();
            }

            // Buys a property if it has no owner otherwise rent is paid to the owner
            if (properties.get(newPosition).getType().equals("property")) {
                if (properties.get(newPosition).getOwner() == null) {
                    System.out.println(currentPlayer.getName() + " landed on an unowned property: " + properties.get(newPosition).getName());
                    System.out.println(currentPlayer.getName() + " buys " + properties.get(newPosition).getName() + " for $" + properties.get(newPosition).getPrice());
                    currentPlayer.buyProperty(properties.get(newPosition));
                } else {
                    currentPlayer.payRent(properties.get(newPosition), currentPlayer.getName());
                }
                System.out.println(currentPlayer.getName() + " now has a Balance of: $" + currentPlayer.getBalance());
            }

            // Increase the current player index and wrap around if necessary
            currentPlayerIndex++;
            if (currentPlayerIndex >= players.size()) {
                currentPlayerIndex = 0;
            }

            System.out.println();
        }

        // The game is over and the player who is not bankrupt is the winner
        double maxBalance = Double.MIN_VALUE;
        String winnerName = "";
        System.out.println("Final Player Outcomes: ");
        System.out.println();

        for (Player player : players) {

            System.out.println("Name: " + player.getName() + ", Balance: $" + player.getBalance() + ", Position: " + player.getPosition());
            if (player.getBalance() > maxBalance) {
                maxBalance = player.getBalance();
                winnerName = player.getName();
            }
        }

        System.out.println();
        System.out.println(winnerName + " is the winner with a balance of $" + maxBalance);
    }

    // Uses the isBankrupt method from players class to tell this method in Game class to return true or false if
    // a player is Bankrupt
    private static boolean isAnyPlayerBankrupt(List<Player> players) {
        for (Player player : players) {
            if (player.isBankrupt()) {
                return true;
            }
        }
        return false;
    }
}
