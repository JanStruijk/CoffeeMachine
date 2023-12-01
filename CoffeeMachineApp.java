package machine;

import java.util.Scanner;

public class CoffeeMachineApp {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(550, 400, 540, 120, 9);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();

            if (action.equals("exit")) {
                break;
            }

            coffeeMachine.processInput(action);
        }
    }
}