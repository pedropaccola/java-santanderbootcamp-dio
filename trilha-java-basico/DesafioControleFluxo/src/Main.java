import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);

        System.out.println("Type the first parameter");
        int firstParameter = scanner.nextInt();

        System.out.println("Type the second parameter");
        int secondParameter = scanner.nextInt();

        try {
           count(firstParameter, secondParameter);
        } catch (InvalidParameterException e) {
            System.out.println("ERROR: The first parameter must be smaller than the second");
        }
    }

    public static void count(int firstParameter, int secondParameter) throws InvalidParameterException {
        if (firstParameter > secondParameter) {
            throw new InvalidParameterException();
        } else {
            int count = secondParameter - firstParameter;
            for (int i = 1; i <= count; i++) {
                System.out.println("Printing number " + i);
            }
        }
    }
}
