package model;

public class Game {
    private String name;
    private double discount;
    private double price;
    private String link;


    public Game(String name, double discount, double price, String link) {
        this.name = name;
        this.discount = discount;
        this.price = price;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPrice() {
        return price;
    }

    public String getLink() {
        return link;
    }

    public boolean equalsNamePriceDiscount(Game game) {
        return (this.name.equals(game.getName()) &&
                this.discount == game.getDiscount() &&
                this.price == game.getPrice());
    }
}
