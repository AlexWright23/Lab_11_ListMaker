import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> itemList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;

        do {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "[AaDdPpQq]", "Please enter your choice: ");

            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = confirmQuit();
                    break;
            }

        } while (!quit);

        System.out.println("Thanks for using the program!");
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void addItem() {
        String newItem = SafeInput.getNonEmptyString(scanner, "Please enter an item to add: ");
        itemList.add(newItem);
        System.out.println("The item was successfully added!");
    }

    private static void deleteItem() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty. There is nothing to delete.");
            return;
        }

        printNumberedItems();
        int itemNumber = SafeInput.getRangedInt(scanner, "Enter the item number to delete: ", 1, itemList.size());

        String removedItem = itemList.remove(itemNumber - 1);
        System.out.println("Item '" + removedItem + "' successfully deleted!");
    }

    private static void printList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Current List:");
            for (String item : itemList) {
                System.out.println("- " + item);
            }
        }
    }

    private static void printNumberedItems() {
        System.out.println("Numbered List:");
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }

    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm(scanner, "Are you sure you want to quit the program?");
    }
}

