import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TerminalAccount account = new TerminalAccount();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Please type your account number: (e.g.: 1024)");
        int number = scanner.nextInt();
        account.setNumber(number);
        scanner.nextLine();

        System.out.println("Please type your account agency: (e.g.: 067-8)");
        String agency = scanner.nextLine();
        account.setAgency(agency);

        System.out.println("Please type your name: (e.g.: Mario Andrade)");
        String name = scanner.nextLine();
        account.setCustomerName(name);

        System.out.println("Please type your account balance: (e.g.: 237.48)");
        double balance = scanner.nextDouble();
        account.setBalance(balance);
        scanner.nextLine();

        System.out.println("Hello " + account.getCustomerName() + ", thanks for creating an account in our bank, your agency is " + account.getAgency() + ", account " + account.getNumber() + " and your balance of $" + account.getBalance() + " is already available for withdrawal.");

    }
}
