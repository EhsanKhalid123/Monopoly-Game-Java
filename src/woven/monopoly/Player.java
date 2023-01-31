package woven.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Class to represent a player in the game
public class Player {

    // Variable Declaration
    private String name;
    private int balance;
    private int  position;
    private int  previousPosition;
    private List<Property> ownedProperties;
    private Map<String, List<Property>> propertiesByColor;

    // Constructor - A player requires all the following information
    public Player(String name){
        this.name = name;
        this.balance = 16;
        this.position = 0;
        this.previousPosition = 0;
        this.ownedProperties = new ArrayList<>();
    }

    // This allows player to buy property if it is available and then subtracts
    // the property amount from their balance and also the player now owns it
    public void buyProperty(Property property){
        if (property.isAvailable() && this.balance >= property.getPrice()){
            this.balance -= property.getPrice();
            this.ownedProperties.add(property);
            property.setOwner(this);
        }
    }

    // If the property player lands on is not owned by them then they pay rent
    // and if the owner of the property owns all the same coloured property the
    // rent is doubled
    public void payRent(Property property){
        if (!property.isAvailable() && property.getOwner() != this){
            int rent = property.getRent();
            if (property.getOwner().hasMonopoly()){
                rent *= 2;
                System.out.println("You have to pay double rent");
            }
            this.balance -= rent;
            property.getOwner().balance += rent;
        }
    }

    // Checks if the player has a monopoly over all properties with the same colour
    public boolean hasMonopoly(){
//        boolean monopoly = true;
        return false;
    }

    // If player money is less than or equal to 0 then player is bankrupt
    public boolean isBankrupt(){
        return this.balance <= 0;
    }

    // Get method for player names
    public String getName() {
        return name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // Get method for amount of money
    public Integer getBalance() {
        return balance;
    }

    // Get method for players position on board
    public int getPosition() {
        return position;
    }

    // Set method for players position on board
    public void setPosition(int position) {
        this.position = position;
    }

    public int getPreviousPosition() {
        return previousPosition;
    }

    public void setPreviousPosition(int previousPosition) {
        this.previousPosition = previousPosition;
    }

    // Get method for all the owned properties for a player
    public List<Property> getOwnedProperties() {
        return ownedProperties;
    }
}
