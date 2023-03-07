import java.util.Arrays;
import java.util.Scanner;

public class TP2 {

    private static Scanner scanner;

    public static void main(String[] args) {

        System.out.println("Start of program");

        scanner = new Scanner(System.in);

        // fibonacci1();
        // fibonacci2();
        // fibonacci3();
        // listDigits();

        int[] array = generateArray(10, 0, 100);

        // countAndSortArray(array);
        // bubbleSortArray(array);
        // bubbleSortArray2(array);
        // bubbleSortArray3(array);
        // quickSortArray(array, 0, array.length - 1);
        conway("abc", 1);

        scanner.close();

        System.out.println("End of program");

    }

    private static void fibonacci1() {
        int howMany = -1;
        do {
            System.out.print("Enter a number: ");
            howMany = scanner.nextInt();
        } while (howMany < 0);

        int prevPrevNum = 0;
        int prevNum = 1;
        int currentNumber = 0;

        if (howMany == 0) {
            System.out.println(prevPrevNum);
            System.out.println("Fibo at F" + howMany + " = " + prevPrevNum);
        } else if (howMany == 1) {
            System.out.println(prevPrevNum + " " + prevNum + " ");
            System.out.println("Fibo at F" + howMany + " = " + prevNum);
        } else {
            System.out.print(prevPrevNum + " " + prevNum + " ");
            for (int i = 2; i < howMany + 1; i++) {
                currentNumber = prevNum + prevPrevNum;
                System.out.print(currentNumber + " ");
                prevPrevNum = prevNum;
                prevNum = currentNumber;
            }
            System.out.println(" ");
            System.out.println("Fibo at F" + howMany + " = " + currentNumber);
        }
    }

    private static void fibonacci2() {
        int howMany = -1;
        do {
            System.out.print("Enter a number: ");
            howMany = scanner.nextInt();
        } while (howMany < 0);

        int[] fibonacci;
        fibonacci = new int[howMany + 1];

        if (howMany == 0) {
            fibonacci[0] = 0;
        } else if (howMany == 1) {
            fibonacci[0] = 0;
            fibonacci[1] = 1;
        } else {
            fibonacci[0] = 0;
            fibonacci[1] = 1;
            for (int i = 2; i < howMany + 1; i++) {
                fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
            }
        }

        for (int i : fibonacci) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.println("Fibo at F" + howMany + " = " + fibonacci[howMany]);
    }

    private static void fibonacci3() {
        int howMany = -1;
        do {
            System.out.print("Enter a number: ");
            howMany = scanner.nextInt();
        } while (howMany < 0);

        int prevPrevNum = 0;
        int prevNum = 1;

        if (howMany == 0) {
            System.out.println(prevPrevNum);
            System.out.println("Fibo at F" + howMany + " = " + prevPrevNum);
        } else if (howMany == 1) {
            System.out.println(prevPrevNum + " " + prevNum + " ");
            System.out.println("Fibo at F" + howMany + " = " + prevNum);
        } else {
            System.out.print(prevPrevNum + " " + prevNum + " ");
            int i = 2;
            printFibonacci(i, prevNum, prevPrevNum, howMany);
        }
    }

    private static void printFibonacci(int i, int prevNum, int prevPrevNum, int howMany) {
        int currentNumber = prevNum + prevPrevNum;
        System.out.print(currentNumber + " ");
        prevPrevNum = prevNum;
        prevNum = currentNumber;
        i++;
        if (i < howMany + 1) {
            printFibonacci(i, prevNum, prevPrevNum, howMany);
        } else {
            System.out.println(" ");
            System.out.println("Fibo at F" + howMany + " = " + currentNumber);
        }
    }

    private static void listDigits() {
        int number = -1;
        do {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        } while (number < 1);

        int inverseNumber = 0;

        while (number > 0) {
            int rest = number % 10;
            System.out.println(rest);
            number = number / 10;
            inverseNumber = inverseNumber * 10 + rest;
        }

        System.out.println(inverseNumber);
    }

    private static void countAndSortArray(int[] arrayToSort) {
        int arrayToSortSize = arrayToSort.length;

        int[] histogramArray;
        int[] sortedArray;

        sortedArray = new int[arrayToSortSize];

        int postMin = Integer.MAX_VALUE;
        int postMax = 0;

        for (int i : arrayToSort) {
            if (i > postMax) {
                postMax = i;
            }
            if (i < postMin) {
                postMin = i;
            }
        }

        int histogramSize = postMax - postMin + 1;
        histogramArray = new int[histogramSize];

        for (int i = 0; i < arrayToSortSize; i++) {
            histogramArray[arrayToSort[i] - postMin]++;
        }

        System.out.println(Arrays.toString(arrayToSort));
        System.out.println(Arrays.toString(histogramArray));

        int k = 0;
        for (int i = 0; i < histogramSize; i++) {
            for (int j = 0; j < histogramArray[i]; j++) {
                sortedArray[k] = i + postMin;
                k++;
            }
        }

        System.out.println(Arrays.toString(sortedArray));
    }

    private static void bubbleSortArray(int[] array) {
        int arraySize = array.length;

        System.out.println(Arrays.toString(array));

        for (int i = arraySize; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if ((j + 1) < i && array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
                System.out.println("------Inner loop: " + Arrays.toString(array));
            }
            System.out.println("Main loop: " + Arrays.toString(array));
        }
    }

    private static void bubbleSortArray2(int[] array) {
        int arraySize = array.length;

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < arraySize; i++) {
            for (int j = 1; j < (arraySize - i); j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
                System.out.println("------Inner loop: " + Arrays.toString(array));
            }
            System.out.println("Main loop: " + Arrays.toString(array));
        }
    }

    private static void bubbleSortArray3(int[] array) {

        System.out.println(Arrays.toString(array));

        int temp;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSortArray(int[] array, int originalStartIndex, int originalEndIndex) {
        int startIndex = originalStartIndex;
        int endIndex = originalEndIndex;

        System.out.println(Arrays.toString(array));

        while (startIndex < endIndex) {
            if (array[startIndex] > array[endIndex]) {
                int temp = array[startIndex];
                array[startIndex] = array[endIndex - 1];
                array[endIndex - 1] = array[endIndex];
                array[endIndex] = temp;
                endIndex--;
                System.out.println(Arrays.toString(array));
            } else {
                startIndex++;
            }
        }

        if (endIndex - originalStartIndex >= 2) {
            quickSortArray(array, originalStartIndex, endIndex - 1);
        }

        if (originalEndIndex - endIndex >= 2) {
            quickSortArray(array, endIndex + 1, originalEndIndex);
        }
    }


    private static int[] generateArray(int arraySize, int min, int max) {
        int[] array;
        array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) (Math.random() * (max - min)) + min;
        }

        return array;
    }

    private static String conway(String s, int n) {

        String result = "";

        int indice = 0;

        // Initialisation de c par le premier caractère de la chaîne
        char c = s.charAt(indice);
        // Le compteur est initialisé à 1 car c est écrit déjà) une fois
        int cpt = 1;

        // On boucle tant que notre indice plus le compteur ne dépasse pas la taille de
        // la chaîne
        while ((indice + cpt) < s.length()) {

            // On cherche à compter le nombre de caractère égaux à c.
            if (s.charAt(indice + cpt) == c) {
                // Oui on a le même, on incrémente notre compteur et on tente de repartir pour
                // un tour pour regarder le caractère suivant.
                cpt++;
            } else {
                // Non on n'a pas le même caractère. On construit la nouvelle chaîne en disant
                // le nombre de fois (cpt) que l'on a compter le caractère.
                result += cpt + "" + c;

                // On décale l'indice
                indice += cpt;

                // On redéfini le caractère suivant et son nombre d'occurrences
                c = s.charAt(indice);
                cpt = 1;
            }
        }

        // On écrit le nombre d'occurrence du dernier caractère vu.
        result += cpt + "" + c;

        System.out.println(result);

        return result;
    }
}
