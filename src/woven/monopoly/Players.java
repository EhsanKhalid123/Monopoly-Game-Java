package woven.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private String player1 = "Peter";
    private String player2 = "Billy";
    private String player3 = "Charlotte";
    private String player4 = "Sweedal";

    private String playerName;
    private Integer money;
    private List<String> ownedProperties = new ArrayList<String>();

    // Constructor - A player requires all the following information
    public Players(String playerName, Integer money, List<String> ownedProperties){

        this.playerName = playerName;
        this.money = money;
        this.ownedProperties = ownedProperties;

    }

}
