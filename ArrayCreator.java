import java.util.Arrays;
import java.util.Scanner;

public class ArrayCreator {

//Arrays creator

    public static void main(String[] args) {

        int[] numbers = createArray();
        fillArray(numbers);
        double average = calculateAverage(numbers);
        int highest = calculateHighest(numbers);
        printAverageAndHighest(average, highest);
    }

    private static int[] createArray() {

        System.out.println("Please insert required array size:");
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()) {
            System.out.println("That's not correct a number!");
            scanner.next();
        }

        int size = scanner.nextInt();
        return new int[size];
    }


    private static void fillArray(int[] numbers) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("You will now be asked to insert values (whole numbers) to each of the cells of array");

        int currentCell = 0;

        for (int ignored : numbers) {
            int displayedCurrentCell = currentCell + 1;
            System.out.println("Please insert value for cell " + displayedCurrentCell + " out of " + numbers.length);

            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }

            numbers[currentCell] = scanner.nextInt();
            currentCell++;
        }
    }

    private static double calculateAverage(int[] numbers) {

        double sumOfValues = 0.00;

        for (int x : numbers) {
            sumOfValues += x;
        }


        return sumOfValues / numbers.length;
    }

    private static int calculateHighest(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 1];
    }

    private static void printAverageAndHighest(double avg, int high) {
        System.out.println("Average value in created array was = " + avg);
        System.out.println("Highest value insterted into array was = " + high);
    }
}
