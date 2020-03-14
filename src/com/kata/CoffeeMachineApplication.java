package com.kata;

public class CoffeeMachineApplication {

    public static void main(String[] args) {

        System.out.println("################################# FIRST ITERATION #################################");

        CustomerOrder order01 = new CustomerOrder(Drink.TEA,1);
        CustomerOrder order02 = new CustomerOrder(Drink.COFFEE, 2);
        CustomerOrder order03 = new CustomerOrder(Drink.TEA);
        CustomerOrder order04 = new CustomerOrder(Drink.CHOCOLATE,2);

        System.out.println("Drink maker makes 1 tea with 1 sugar and a stick -> In machine maker language : " + order01.sendToDrinkMaker());
        System.out.println("Drink maker makes 1 coffee with 2 sugar and a stick -> In machine maker language : " +order02.sendToDrinkMaker());
        System.out.println("Drink maker makes 1 tea with no sugar and - therefore no stick -> In machine maker language : " +order03.sendToDrinkMaker());
        System.out.println("Drink maker makes 1 chocolate with 2 sugar and one stick -> In machine maker language : "+order04.sendToDrinkMaker());

        order03.addSugar(1);

        System.out.println("Drink maker makes 1 tea with 1 sugar and one stick -> In machine maker language : "+order03.sendToDrinkMaker());

        System.out.println("################################# SECOND ITERATION #################################");

        CustomerOrder order06 =  new CustomerOrder(Drink.COFFEE,0.6);
        CustomerOrder order07 =  new CustomerOrder(Drink.CHOCOLATE,1,0.9);
        CustomerOrder order08 =  new CustomerOrder(Drink.TEA,0.1);
        CustomerOrder order09 =  new CustomerOrder(Drink.CHOCOLATE,2,0.36);

        System.out.println(order06.sendToDrinkMaker());
        System.out.println(order07.sendToDrinkMaker());
        System.out.println(order08.sendToDrinkMaker());
        System.out.println(order09.sendToDrinkMaker());

        System.out.println("################################# THIRD ITERATION #################################");

        CustomerOrder order10 =  new CustomerOrder(Drink.ORANGE_JUICE,true, 20.0);
        CustomerOrder order11 =  new CustomerOrder(Drink.TEA,true,1,0.8);
        CustomerOrder order12 =  new CustomerOrder(Drink.COFFEE,true,0.4);
        CustomerOrder order13 =  new CustomerOrder(Drink.CHOCOLATE,true,2,0.36);

        System.out.println(order10.sendToDrinkMaker());
        System.out.println(order11.sendToDrinkMaker());
        System.out.println(order12.sendToDrinkMaker());
        System.out.println(order13.sendToDrinkMaker());

        order12.addSugar(2);
        System.out.println(order12.sendToDrinkMaker());
    }

}
