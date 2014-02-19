
import java.util.Scanner;

public class StoreUI {

    StoreUI() {
        Controller ctrl = new Controller();

        String key;
        System.out.println("Welcome to SmartStore.com \n");

        // Display products from inventory
        Scanner scan;
        boolean done = false;
        while (!done) {
            System.out.println("Please enter a command or 'help':");
            scan = new Scanner(System.in);

            String input = scan.nextLine();

            // Makes all user input lower case no matter the case entered.
            switch (input.toLowerCase()) {
                case "help":
                    String helpOptions = "";
                    helpOptions += "LIST: List items inventory items and counts. \n";
                    helpOptions += "CART: List the contents of the shopping cart. \n";
                    helpOptions += "DETAILS: Display details of requested item. \n";
                    helpOptions += "ADD: Place the requested item into the shopping cart and reduce inventory.. \n";
                    helpOptions += "RETURN: Remove the item from the shopping cart and increase inventory. \n";
                    helpOptions += "QUIT: The message \"quit\" will terminate the program with an appropriate message. \n";
                    helpOptions += "HELP: Show this menu. \n";
                    System.out.println(helpOptions);
                    break;
                case "quit":
                    System.out.println("\n" + "Thank you for your business. Goodbye.");
                    System.exit(0);
                    break;
                case "add":
                    System.out.println("\n" + "Please enter item code you wish to add to cart:");
                    key = scan.nextLine();
                    System.out.println(ctrl.addToCart(key.toUpperCase()));
                    break;
                case "cart":
                    System.out.println(ctrl.getCartItems());
                    break;
                case "return":
                    System.out.println("\n" + "Please enter item code you wish to remove from cart:");
                    key = scan.nextLine();
                    System.out.println(ctrl.removeFromCart(key.toUpperCase()));
                    break;
                case "list":
                    System.out.println(ctrl.listContents());
                    break;
                case "details":
                    System.out.println("\n" + "Please enter product code:");
                    key = scan.nextLine();
                    System.out.println("\n" + ctrl.getProductDetails(key.toUpperCase()));
                    break;
                default:
                    System.out.println("\n" + "I do not understand the word \"" + input + "\" \n");
                    break;
            }
        }
    }
}
