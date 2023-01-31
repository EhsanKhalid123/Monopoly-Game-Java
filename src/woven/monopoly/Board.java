package woven.monopoly;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Board {

    // This method loads the Monopoly Board from the board.json file
    public static List<Property> loadBoard() {

        // Creating a new instance of an object
        List<Property> properties = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            // Reads the JSON file and then uses the parser to parse it and assigns
            // it to jsonProperties and casts is as an JSON Array
            JSONArray jsonProperties = (JSONArray) parser.parse(new FileReader("board.json"));

            // Loops over the jsonProperties and gets each element and adds it to the property list
            for (Object obj : jsonProperties) {
                JSONObject jsonProp = (JSONObject) obj;

                String name = (String) jsonProp.get("name");
                // Since the first item doesn't have price property we need to add a check to avoid null pointer error
                int price = 0;
                if (jsonProp.get("price") != null) {
                    price = ((Long) jsonProp.get("price")).intValue();
                }
                // Since the first item doesn't have colour property we need to add a check to avoid null pointer error
                String colour = "";
                if (jsonProp.get("colour") != null) {
                    colour = (String) jsonProp.get("colour");
                }
                String type = (String) jsonProp.get("type");

                // Adds a Property to the ArrayList
                properties.add(new Property(name, price, colour, type));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        // Returns the list of properties
        return properties;
    }

    // This method loads the Dice rolled numbers from the specified rolls.json files
    public static List<Integer> loadRolls(String diceRollFilePath) {
        List<Integer> rolls = new ArrayList<>();
        JSONParser parser = new JSONParser();

        // Reads the JSON file and then uses the parser to parse it and assigns
        // it to jsonRolls and casts is as an JSON Array
        try {
            Object obj = parser.parse(new FileReader(diceRollFilePath));
            JSONArray jsonRolls = (JSONArray) obj;

            // Loops through the parsed integers jsonRolls and adds each integer to the rolls list
            for (Object roll : jsonRolls) {
                rolls.add(((Long) roll).intValue());
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        // Returns the array list of all the rolled numbers
        return rolls;
    }

    // Method to find how many total properties exist with colour sent through the parameter and returns the number
    public static int propertiesNoWithSameColour(String colour) {
        List<Property> properties = loadBoard();
        int count = 0;
        for (Property property : properties) {
            if (property.getColour().equals(colour)) {
                count++;
            }
        }

        return count;
    }

}
