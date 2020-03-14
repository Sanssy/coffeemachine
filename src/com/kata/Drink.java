package com.kata;

public enum Drink {
    TEA('T',0.6),
    COFFEE('C', 0.4),
    CHOCOLATE('H', 0.5),
    ORANGE_JUICE('O',0.6);

    char id;
    double price;

    Drink(char id, double price) {
        this.id = id;
        this.price = price;
    }
}
