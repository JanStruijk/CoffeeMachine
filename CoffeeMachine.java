package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int money;
    private static int water;
    private static int milk;
    private static int coffeeBeans;
    private static int disposableCups;

    public CoffeeMachine(int money, int water, int milk, int coffeeBeans, int disposableCups) {
        CoffeeMachine.money = money;
        CoffeeMachine.water = water;
        CoffeeMachine.milk = milk;
        CoffeeMachine.coffeeBeans = coffeeBeans;
        CoffeeMachine.disposableCups = disposableCups;
    }
    public void processInput(String input) {
        switch (input) {
            case "buy":
                buyDrink();
                break;
            case "fill":
                fillSupplies();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                displayMachineState();
                break;
            default:
                System.out.println("Invalid action!");
        }
    }
    private static void buyDrink() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy?");

        for (DrinkType drinkType : DrinkType.values()) {
            System.out.println(drinkType.getCode() + " - " + drinkType.getName());
        }

        System.out.println("back - to main menu:");
        String choice = scanner.nextLine();

        if (choice.equals("back")) {
            return;
        }

        int drinkCode = Integer.parseInt(choice);

        for (DrinkType drinkType : DrinkType.values()) {
            if (drinkType.getCode() == drinkCode) {
                makeCoffee(drinkType);
                return;
            }
        }

        System.out.println("Invalid choice!");
    }
    private static void makeCoffee(DrinkType drinkType) {
        if (water >= drinkType.getWaterNeeded() && milk >= drinkType.getMilkNeeded()
                && coffeeBeans >= drinkType.getCoffeeBeansNeeded() && disposableCups > 0) {
            System.out.println("I have enough resources, making " + drinkType.getName() + "!");
            money += drinkType.getCost();
            water -= drinkType.getWaterNeeded();
            milk -= drinkType.getMilkNeeded();
            coffeeBeans -= drinkType.getCoffeeBeansNeeded();
            disposableCups--;
        } else {
            System.out.println("Not enough resources to make " + drinkType.getName() + "!");
        }
    }
    private static void fillSupplies() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        disposableCups += scanner.nextInt();
    }
    private static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
    private static void displayMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }
}