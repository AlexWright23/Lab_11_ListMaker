import java.util.Scanner;

public class SafeInput {

    private static Scanner scanner = new Scanner(System.in);

    public static int getRangedInt(Scanner scanner, String prompt, int min, int max) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // consume the invalid input
            }
            input = scanner.nextInt();
        } while (input < min || input > max);
        scanner.nextLine();
        return input;
    }

    public static String getNonEmptyString(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid value.");
            }
        } while (input.isEmpty());
        return input;
    }

    public static String getRegExString(Scanner scanner, String regex, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.matches(regex)) {
                System.out.println("Invalid input. Please enter a valid value.");
            }
        } while (!input.matches(regex));
        return input;
    }

    public static boolean getYNConfirm(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt + " (Y/N): ");
            input = scanner.nextLine().trim().toUpperCase();
            if (!input.equals("Y") && !input.equals("N")) {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        } while (!input.equals("Y") && !input.equals("N"));
        return input.equals("Y");
    }
}
