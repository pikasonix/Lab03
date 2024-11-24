import java.util.Arrays;
import java.util.Scanner;
public class Array {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("n = ");
        int n = keyboard.nextInt();

        double[] arr = new double[n];
        System.out.println("Array: ");
        for (int i=0; i<n; i++)
            arr[i] = keyboard.nextDouble();

        Arrays.sort(arr);
        System.out.println("Sort: " + Arrays.toString(arr));

        double sum = 0;
        for (double num : arr) sum += num;
        System.out.println("Sum: " + sum);

        double average = sum/n;
        System.out.println("Average: " + average);
    }
}