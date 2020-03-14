package com.kata;

public class CustomerOrder {

    private Drink drink;
    private int sugar;
    private boolean stick;
    private double money;
    private boolean hotOption;

    public CustomerOrder(Drink drink, int sugar) {
        this.drink = drink;
        this.sugar = sugar;
        if (sugar > 0)
            this.stick = true;
    }

    public CustomerOrder(Drink drink, int sugar, double money) {
        this(drink, sugar);
        this.money = money;
    }

    public CustomerOrder(Drink drink, boolean hotOption, int sugar, double money) {
        this(drink, sugar,money);
        this.hotOption = hotOption;
    }

    public CustomerOrder(Drink drink) {
        this.drink = drink;
        this.sugar = 0;
        this.stick = false;
    }

    public CustomerOrder(Drink drink, double money) {
        this(drink);
        this.money = money;
    }

    public CustomerOrder(Drink drink, boolean hotOption, double money) {
        this(drink, money);
        this.hotOption = hotOption;
    }


    String sendToDrinkMaker(){
        final StringBuilder translatedOrder = new StringBuilder();

        if (drink.price <= money){
            translatedOrder.append(drink.id);

            if (hotOption && drink.id != 'O')
                translatedOrder.append('h');

            translatedOrder.append(":");

            if (sugar > 0)
                translatedOrder.append(sugar);

            translatedOrder.append(":");

            if (stick)
                translatedOrder.append("0");

            return translatedOrder.toString();
        } else {
            return translatedOrder.append("Missing money : ").append(String.format("%.2f",drink.price - money)).toString();
        }

    }

    public void addSugar(int sugar) {
        this.sugar = sugar;
        if (sugar>0)
            stick=true;
    }
}
