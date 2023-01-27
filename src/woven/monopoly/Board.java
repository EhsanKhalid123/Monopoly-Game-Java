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

    public List<Property> loadBoard() {
        List<Property> properties = new ArrayList<Property>();
        JSONParser parser = new JSONParser();

        try {
            JSONArray jsonProperties = (JSONArray) parser.parse(new FileReader("board.json"));

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

        return properties;
    }
}


