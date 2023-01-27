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
    public List<Property> loadBoard() {

        // Creating a new instance of an object
        List<Property> properties = new ArrayList<Property>();
        JSONParser parser = new JSONParser();

        try {
            // Reads the JSON file and then uses the parser to parse it and assigns
            // it to jsonProperties and casts is as an JSON Array
            JSONArray jsonProperties = (JSONArray) parser.parse(new FileReader("board.json"));

            // Loops over the jsonProperties and gets each element and adds it to the property list
            for (Object obj : jsonProperties) {
                JSONObject jsonProp = (JSONObject) obj;

                String name = (String) jsonProp.get("name");
                int price = ((Long) jsonProp.get("price")).intValue();
                String colour = (String) jsonProp.get("colour");
                String type = (String) jsonProp.get("type");
                int rent = ((Long) jsonProp.get("rent")).intValue();
                properties.add(new Property(name, price, colour, type, rent));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        // Returns the list of properties
        return properties;
    }
}


