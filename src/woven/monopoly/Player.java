package woven.monopoly;

import java.util.ArrayList;
import java.util.List;

// Class to represent a player in the game
public class Player {

    // Variable Declaration
    private String name;
    private int money;
    private int  position;
    private List<Property> ownedProperties;

    // Constructor - A player requires all the following information
    public Player(String name){
        this.name = name;
        this.money = 16;
        this.position = 0;
        this.ownedProperties = new ArrayList<Property>();
    }

    public void buyProperty(Property property){
        if (property.isAvailable() && this.money >= property.getPrice()){
            this.money -= property.getPrice();
            this.ownedProperties.add(property);
            property.setOwner(this);
        }
    }

    // Get method for player names
    public String getName() {
        return name;
    }

    // Get method for amount of money
    public Integer getMoney() {
        return money;
    }

    // Get method for all the owned properties for a player
    public List<Property> getOwnedProperties() {
        return ownedProperties;
    }
}
