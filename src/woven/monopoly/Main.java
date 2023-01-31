package woven.monopoly;

public class Main {

    public static void main(String[] args) {
        // Creates a new Game object
        Game game = new Game();
        // Calls the startGame() method from Game class to begin the game using Rolls 1 Files
        game.startGame("rolls_1.json");

        // Calls the startGame() method from Game class to begin the game using Rolls 2 Files
        game.startGame("rolls_2.json");
    }
}
