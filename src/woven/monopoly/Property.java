package woven.monopoly;

public class Property {

    private String name;
    private Integer price;
    private String colour;
    private String type;

    private Property(String name, Integer price, String colour, String type){
        this.name = name;
        this.price = price;
        this.colour = colour;
        this.type = type;
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
}
