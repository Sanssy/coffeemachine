package com.kata.drinkMaker;

import com.kata.statistics.Reporting;
import com.kata.coffeeMachine.BeverageQuantityChecker;
import com.kata.coffeeMachine.CoffeeMachine;
import com.kata.coffeeMachine.EmailNotifier;

public class CustomerOrder {

    private final Drink drink;
    private int sugar = 0;
    private boolean stick = false;
    private double money;
    private boolean hotOption;

    public CustomerOrder(Drink drink) {
        this.drink = drink;
    }

    public CustomerOrder(Drink drink, int sugar) {
        this(drink);
        this.addSugar(sugar);
    }

    public CustomerOrder(Drink drink, double money) {
        this(drink);
        this.money = money;
    }

    public CustomerOrder(Drink drink, int sugar, double money) {
        this(drink, sugar);
        this.money = money;
    }

    public CustomerOrder(Drink drink, boolean hotOption, double money) {
        this(drink, money);
        this.hotOption = hotOption;
    }

    public CustomerOrder(Drink drink, boolean hotOption, int sugar, double money) {
        this(drink, sugar, money);
        this.hotOption = hotOption;
    }

    public void addSugar(int sugar) {
        this.sugar = sugar;
        if (sugar>0)
            stick=true;
    }

    public String sendToDrinkMaker(){
        if (hasNotEnoughMoney())
            return missingMoneyMessage();

        if (runOutOfDrink())
            return runOutDrinkProcessMessage();

        reportingTrigger();

        return drinkMakerTranslationStep();
    }

    private boolean hasNotEnoughMoney() {
        return !(drink.price <= money);
    }

    private String missingMoneyMessage() {
        return "Missing money : " + String.format("%.2f", drink.price - money);
    }

    private boolean runOutOfDrink() {
        return CoffeeMachine.currentMachine().check().isEmpty(Character.toString(drink.id));
    }

    private String runOutDrinkProcessMessage() {
        CoffeeMachine.currentMachine().sendNotification().notifyMissingDrink(Character.toString(drink.id));
        return "Run out of : " + drink.name;
    }

    private void reportingTrigger() {
        Reporting.addToStatistics(drink,hotOption);
    }

    private String drinkMakerTranslationStep() {
        final StringBuilder translatedOrder = new StringBuilder();

        translatedOrder.append(drink.id);

        if (hotOption && drink.id != Drink.ORANGE_JUICE.id)
            translatedOrder.append('h');

        translatedOrder.append(":");

        if (sugar > 0)
            translatedOrder.append(sugar);

        translatedOrder.append(":");

        if (stick)
            translatedOrder.append("0");

        return translatedOrder.toString();
    }
}
