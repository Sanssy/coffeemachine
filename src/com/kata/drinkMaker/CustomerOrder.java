package com.kata.drinkMaker;

import com.kata.statistics.Reporting;
import com.kata.coffeeMachine.BeverageQuantityChecker;
import com.kata.coffeeMachine.CoffeeMachine;
import com.kata.coffeeMachine.EmailNotifier;

public class CustomerOrder {

    private Drink drink;
    private int sugar;
    private boolean stick;
    private double money;
    private boolean hotOption;
    private EmailNotifier emailNotifier;
    private BeverageQuantityChecker beverageQuantityChecker;

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


    public String sendToDrinkMaker(){
        final StringBuilder translatedOrder = new StringBuilder();

        if (hasEnoughMoney())
            return translatedOrder.append("Missing money : ").append(String.format("%.2f",drink.price - money)).toString();

        if (CoffeeMachine.currentMachine().check().isEmpty(Character.toString(drink.id))){
            CoffeeMachine.currentMachine().sendNotification().notifyMissingDrink(Character.toString(drink.id));
            return "Run out of : " + drink.name;
        }

        drinkMakerTranslationStep(translatedOrder);

        Reporting.addToStatistics(drink,hotOption);

        return translatedOrder.toString();
    }

    private void drinkMakerTranslationStep(StringBuilder translatedOrder) {
        translatedOrder.append(drink.id);

        if (hotOption && drink.id != 'O')
            translatedOrder.append('h');

        translatedOrder.append(":");

        if (sugar > 0)
            translatedOrder.append(sugar);

        translatedOrder.append(":");

        if (stick)
            translatedOrder.append("0");
    }

    private boolean hasEnoughMoney() {
        return !(drink.price <= money);
    }

    public void addSugar(int sugar) {
        this.sugar = sugar;
        if (sugar>0)
            stick=true;
    }
}
