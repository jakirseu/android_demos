package me.jakir.localxmlparsing;

/**
 * Created by Jack on 2/17/2016.
 */
public class Food {

    private String name;
    private String price;
    private String description;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return " Name = " + name + "\n Price = " + price +  "\n Description = "+description;
    }
}