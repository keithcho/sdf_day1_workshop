import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");
        List<String> cart = new ArrayList<>();

        String command = "";
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            command = scan.next().toLowerCase();

            switch (command) {
                // List items in the cart
                case "list":
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty");
                    } else {
                        for (int i = 0; i < cart.size(); i++) {
                            System.out.printf("%d. %s\n", i+1, cart.get(i));
                        }
                    }
                    break;
                // Add items to the cart
                case "add":
                    String[] items = scan.nextLine().trim().split(",");
                    for (int i = 0; i < items.length; i++) {
                        if (cart.contains(items[i].trim())) {
                            System.out.printf("You have %s in your cart\n", items[i].trim());
                        } else {
                            cart.add(items[i].trim());
                            System.out.printf("%s added to cart\n", items[i].trim());
                        }
                    }
                    break;
                case "delete":
                    int deleteIndex = scan.nextInt();
                        if (deleteIndex <= cart.size()) {
                            System.out.printf("%s removed from cart\n", cart.get(deleteIndex-1));
                            cart.remove(deleteIndex-1);
                        } else {
                            System.out.println("Incorrect item index");
                        }
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.err.println("Command not recognized. Please try again\n");
                }
        }
    }
}