package com.kata;

public class CoffeeMachineApplication {

    public static void main(String[] args) {

        CustomerOrder order01 = new CustomerOrder(Drink.TEA, 1);
        CustomerOrder order02 = new CustomerOrder(Drink.COFFEE, 2);
        CustomerOrder order03 = new CustomerOrder(Drink.TEA);
        CustomerOrder order04 = new CustomerOrder(Drink.CHOCOLATE,2);
        CustomerOrder order05 = new CustomerOrder(Drink.GINGERBEER,2);

        System.out.println("Drink maker makes 1 tea with 1 sugar and a stick -> In machine maker language : " + order01.sendToDrinkMaker());
        System.out.println("Drink maker makes 1 coffee with 2 sugar and a stick -> In machine maker language : " +order02.sendToDrinkMaker());
        System.out.println("Drink maker makes 1 tea with no sugar and - therefore no stick -> In machine maker language : " +order03.sendToDrinkMaker());
        System.out.println("Drink maker makes 1 chocolate with 2 sugar and one stick -> In machine maker language : "+order04.sendToDrinkMaker());
        System.out.println("Drink maker rejects unknown drinks : "+order05.sendToDrinkMaker());

        order03.addSugar(1);

        System.out.println("Drink maker makes 1 tea with 1 sugar and one stick -> In machine maker language : "+order03.sendToDrinkMaker());

    }

}
