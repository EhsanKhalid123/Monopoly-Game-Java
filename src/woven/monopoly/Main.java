package woven.monopoly;

public class Main {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        // Creates a new Game object
        Game game = new Game();
        // Calls the startGame() method from Game class to begin the game using Rolls 1 Files
        System.out.println(ANSI_GREEN + "Starting Game 1 with Roll 1" + ANSI_RESET);
        game.startGame("rolls_1.json");

        System.out.println();
        System.out.println();

        // Calls the startGame() method from Game class to begin the game using Rolls 2 Files
        System.out.println(ANSI_GREEN + "Starting Game 2 with Roll 2" + ANSI_RESET);
        game.startGame("rolls_2.json");
    }
}
