import java.util.Scanner;

public class TP1 {

    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Start of program");

        scanner = new Scanner(System.in);

        // welcomeUser();
        // swap();
        // compareStrings();
        // isLeapYear();
        // showRandomNumbers();
        // guessGame1();
        guessGame2();

        scanner.close();

        System.out.println("End of program");

    }

    public static void welcomeUser() {
        // Déclaration
        String firstName;
        String lastName;
        int age;

        // Initialisation
        System.out.print("First name: ");
        firstName = scanner.next();

        System.out.print("Last name: ");
        lastName = scanner.next();

        System.out.print("Age: ");
        age = scanner.nextInt();

        // Utilisation
        System.out.println("Hello, " + firstName + " " + lastName + " (" + age + ").");
    }

    public static void swap() {
        int x;
        int y;

        System.out.print("Enter value of x: ");
        x = scanner.nextInt();

        System.out.print("Enter value of y: ");
        y = scanner.nextInt();

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("The values are swapped, x is " + x + " and y is " + y);
    }

    public static void compareStrings() {
        String string1;
        String string2;
        int string1Length;
        int string2Length;

        System.out.print("Enter the first string: ");
        string1 = scanner.next();

        System.out.print("Enter the second string: ");
        string2 = scanner.next();

        if (string1.length() > string2.length()) {
            System.out.println(string1 + " is the longer string");
        } else if (string1.length() < string2.length()) {
            System.out.println(string2 + " is the longer string");
        } else {
            System.out.println("The two strings are the same length");
        }
    }

    public static void isLeapYear() {
        short year;

        System.out.print("Enter a year: ");
        year = scanner.nextShort();

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("The year " + year + " is a leap year");
        } else {
            System.out.println("The year " + year + " is not a leap year");
        }
    }

    public static void showRandomNumbers() {
        int minNumber = 101;
        int minNumberKey = 0;
        int maxNumber = -1;
        int maxNumberKey = 0;

        for (int i = 1; i < 11; i++) {
            int rand = (int) (Math.random() * 101);
            if (rand < minNumber) {
                minNumber = rand;
                minNumberKey = i;
            }
            if (rand > maxNumber) {
                maxNumber = rand;
                maxNumberKey = i;
            }
            System.out.println("The number " + i + " is " + rand);
        }
        System.out.println("The maximum is " + maxNumber + " (number " + maxNumberKey + "), the minimum is " + minNumber + " (number " + minNumberKey + ").");
    }

    public static void guessGame1() {
        int goal = (int) (Math.random() * 101);
        boolean found = false;
        int numberOfAttempts = 1;

        while (!found) {
            System.out.print("Enter a number: ");
            int guess = scanner.nextInt();
            int difference = Math.abs(guess - goal);

            if (difference > 20) {
                System.out.println("-----> cold");
            } else if (difference > 5) {
                System.out.println("-----> warm");
            } else if (difference > 0) {
                System.out.println("-----> hot");
            } else {
                System.out.println("-----> win (" + numberOfAttempts + " attempts)");
                found = true;
            }
            numberOfAttempts++;
        }
    }

    public static void guessGame2() {

        int guess;
        int goal;
        int attempts = 0;
        int lastTooSmall = 0;
        int lastTooBig = 100;

        do {
            System.out.print("Enter a number between 0 and 100: ");
            goal = scanner.nextInt();
        } while (goal < 0 || goal > 100);

        do {
            // guess = (int) (Math.random() * (lastTooBig - lastTooSmall) + lastTooSmall);
            guess = (lastTooBig - lastTooSmall) / 2 + lastTooSmall;

            System.out.println("The attempt of the computer: " + guess + " between [" + lastTooSmall + ", " + lastTooBig + "[");
            attempts++;
            if (guess < goal) {
                System.out.println("It's too small!");
                lastTooSmall = guess + 1;
            } else if (guess > goal) {
                System.out.println("It's too big!");
                lastTooBig = guess;
            } else {
                System.out.println("It's found: " + guess + " (" + attempts + " attempts)");
            }
        } while (guess != goal);
    }

}
