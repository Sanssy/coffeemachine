package com.kata.drinkMaker;

public enum Drink {
    TEA('T',"Tea",0.6),
    COFFEE('C',"Coffee", 0.4),
    CHOCOLATE('H',"Chocolate", 0.5),
    ORANGE_JUICE('O',"Orange Juice",0.6);

    public final String name;
    public final char id;
    public final double price;

    Drink(char id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Drink getDrink(final String ref) {
        for (final Drink drink : Drink.values())
            if (Character.toString(drink.id).equals(ref))
                return drink;
        return null;
    }
}
