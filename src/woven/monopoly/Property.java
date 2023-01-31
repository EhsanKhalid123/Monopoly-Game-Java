package woven.monopoly;

import java.util.List;

// Class to represent a property in the game
public class Property {

    // Variable Declaration
    private String name;
    private int price;
    private String colour;
    private String type;
    private int rent;
    private Player owner;

    // Constructor - A Property requires all the following information
    public Property(String name, int price, String colour, String type){
        this.name = name;
        this.price = price;
        this.colour = colour;
        this.type = type;
        this.rent = 3;
        this.owner = null;
    }

    // Checks if the property player landed on is available for purchase
    public boolean isAvailable(){
        return this.owner == null;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getColour() {
        return colour;
    }

    public String getType() {
        return type;
    }

    public int getRent() {
        return rent;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
