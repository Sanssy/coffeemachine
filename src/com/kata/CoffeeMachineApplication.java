package com.kata;

import com.kata.coffeeMachine.CoffeeMachine;
import com.kata.coffeeMachine.EmailNotifier;
import com.kata.drinkMaker.CustomerOrder;
import com.kata.drinkMaker.Drink;
import com.kata.statistics.Reporting;

import static com.kata.drinkMaker.Drink.*;

public class CoffeeMachineApplication {

    public static void main(String[] args) {

        System.out.println("################################# FIFTH ITERATION #################################");

        System.out.println("Turning on Coffee Machine...");
        System.out.println("Coffee Machine ready to take orders");
        EmailNotifier messageObject = drink -> System.out.println("Object : Empty Beverage ");

//        System.out.println("Case #1 : always empty");
//        CoffeeMachine.initCoffeeMachine((drinkRef) -> true, messageObject);

//        System.out.println("Case #2 : never empty");
//        CoffeeMachine.initCoffeeMachine((drinkRef) -> false, messageObject);

//        System.out.println("Case #3 : if all beverages has been taken once then the coffee machine will run out");
//          CoffeeMachine.initCoffeeMachine((s) -> Reporting.stats(Drink.getDrink(s)).timesServed() >= 1,messageObject);

        System.out.println("Case #4 : custom limit for each beverage");
        CoffeeMachine.initCoffeeMachine(
                (s) -> {
            int maxAvailable;
            switch (Drink.getDrink(s)){
                case CHOCOLATE:
                    maxAvailable = 10;
                    break;
                case COFFEE:
                    maxAvailable = 12;
                    break;
                case ORANGE_JUICE:
                    maxAvailable = 11;
                    break;
                case TEA:
                    maxAvailable = 31;
                    break;
                default:
                    throw new IllegalStateException();
            }
            return Reporting.stats(Drink.getDrink(s)).timesServed() >= maxAvailable;
        },messageObject);

        System.out.println("################################# FIRST ITERATION #################################");

        CustomerOrder order01 = new CustomerOrder(Drink.TEA,1,1);
        CustomerOrder order02 = new CustomerOrder(Drink.COFFEE, 2,4);
        CustomerOrder order03 = new CustomerOrder(Drink.TEA,1.3);
        CustomerOrder order04 = new CustomerOrder(CHOCOLATE,2,4);

        System.out.println("Drink maker makes 1 tea with 1 sugar and a stick -> In machine maker language : " + order01.sendToDrinkMaker());
        System.out.println("Drink maker makes 1 coffee with 2 sugar and a stick -> In machine maker language : " +order02.sendToDrinkMaker());
        System.out.println("Drink maker makes 1 tea with no sugar and - therefore no stick -> In machine maker language : " +order03.sendToDrinkMaker());
        System.out.println("Drink maker makes 1 chocolate with 2 sugar and one stick -> In machine maker language : "+order04.sendToDrinkMaker());

        order03.addSugar(1);

        System.out.println("Drink maker makes 1 tea with 1 sugar and one stick -> In machine maker language : "+order03.sendToDrinkMaker());

        System.out.println("################################# SECOND ITERATION #################################");

        CustomerOrder order06 =  new CustomerOrder(Drink.COFFEE,0.6);
        CustomerOrder order07 =  new CustomerOrder(CHOCOLATE,1,0.9);
        CustomerOrder order08 =  new CustomerOrder(Drink.TEA,0.1);
        CustomerOrder order09 =  new CustomerOrder(CHOCOLATE,2,0.36);

        System.out.println(order06.sendToDrinkMaker());
        System.out.println(order07.sendToDrinkMaker());
        System.out.println(order08.sendToDrinkMaker());
        System.out.println(order09.sendToDrinkMaker());

        System.out.println("################################# THIRD ITERATION #################################");

        CustomerOrder order10 =  new CustomerOrder(Drink.ORANGE_JUICE,true, 20.0);
        CustomerOrder order11 =  new CustomerOrder(Drink.TEA,true,1,0.8);
        CustomerOrder order12 =  new CustomerOrder(Drink.COFFEE,true,0.4);
        CustomerOrder order13 =  new CustomerOrder(CHOCOLATE,true,2,0.36);
        CustomerOrder order14 =  new CustomerOrder(CHOCOLATE,true,2,1.36);

        System.out.println(order10.sendToDrinkMaker());
        System.out.println(order11.sendToDrinkMaker());
        System.out.println(order12.sendToDrinkMaker());
        System.out.println(order13.sendToDrinkMaker());
        System.out.println(order14.sendToDrinkMaker());

        order12.addSugar(2);
        System.out.println(order12.sendToDrinkMaker());

        System.out.println("################################# FOURTH ITERATION #################################");

        Reporting.viewReport();
    }

}
