package woven.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Players {

    // Variable Declaration
    private String playerName;
    private Integer money;
    private List<String> ownedProperties;

    // Constructor - A player requires all the following information
    public Players(String playerName, Integer money, List<String> ownedProperties){
        this.playerName = playerName;
        this.money = money;
        this.ownedProperties = ownedProperties;
    }

    // Get method for player names
    public String getPlayerName() {
        return playerName;
    }

    // Get method for amount of money
    public Integer getMoney() {
        return money;
    }

    // Get method for all the owned properties for a player
    public List<String> getOwnedProperties() {
        return ownedProperties;
    }
}
