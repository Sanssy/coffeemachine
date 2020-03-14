package com.kata;

public class CustomerOrder {

    private Drink drink;
    private int sugar;
    private boolean stick;

    public CustomerOrder(Drink drink, int sugar) {
        this.drink = drink;
        this.sugar = sugar;
        if (sugar > 0)
            this.stick = true;
    }

    public CustomerOrder(Drink drink) {
        this.drink = drink;
        this.sugar = 0;
        this.stick = false;
    }

    String sendToDrinkMaker(){
        final StringBuilder translatedOrder = new StringBuilder();
        switch (drink){
            case CHOCOLATE:
                translatedOrder.append("H");
                break;
            case COFFEE:
                translatedOrder.append("C");
                break;
            case TEA:
                translatedOrder.append("T");
                break;
            default:
                return "Wrong order";
        }

        translatedOrder.append(":");

        if (sugar > 0)
            translatedOrder.append(sugar);

        translatedOrder.append(":");

        if (stick)
            translatedOrder.append("0");

        return translatedOrder.toString();
    }

    public void addSugar(int sugar) {
        this.sugar = sugar;
        if (sugar>0)
            this.stick=true;
    }
}
