package com.kata.coffeeMachine;

public class CoffeeMachine {

    private static CoffeeMachine coffeeMachine;
    private BeverageQuantityChecker check;
    private EmailNotifier notifier;

    private CoffeeMachine(BeverageQuantityChecker check, EmailNotifier notify) {
        this.check = check;
        this.notifier = notify;
    }

    public static void initCoffeeMachine(BeverageQuantityChecker checkin, EmailNotifier notifier){
        coffeeMachine = new CoffeeMachine(checkin, notifier);
    }

    public BeverageQuantityChecker check() {
        return check;
    }

    public static CoffeeMachine currentMachine() {
        return coffeeMachine;
    }

    public EmailNotifier sendNotification(){
        return notifier;
    }
}
