package woven.monopoly;

public class Game {

    public Game(){
        Board board = new Board();
        board.createBoard("board.json");
        createPlayers();
    }

    public void createPlayers(){
        Players player1 = new Players("Peter", 16, null);
        Players player2 = new Players("Billy", 16, null);
        Players player3 = new Players("Charlotte", 16, null);
        Players player4 = new Players("Sweedal", 16, null);

        System.out.println(player1.getPlayerName() + ", $" + player1.getMoney() + ", " + player1.getOwnedProperties());
        System.out.println(player2.getPlayerName() + ", $" + player2.getMoney() + ", " + player2.getOwnedProperties());
        System.out.println(player3.getPlayerName() + ", $" + player3.getMoney() + ", " + player3.getOwnedProperties());
        System.out.println(player4.getPlayerName() + ", $" + player4.getMoney() + ", " + player4.getOwnedProperties());
    }


}
