package hust.soict.dsai.lab01;

import java.util.Scanner;
public class Matrix {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("row: ");
        int row = keyboard.nextInt();
        System.out.print("col: ");
        int col = keyboard.nextInt();

        int[][] matrix1 = new int[row][col];
        int[][] matrix2 = new int[row][col];
        int[][] matrix  = new int[row][col];

        System.out.println("matrix 1:");
        for (int i=0; i<row; i++)
            for (int j=0; j<col; j++)
                matrix1[i][j] = keyboard.nextInt();

        System.out.println("matrix 2:");
        for (int i=0; i<row; i++)
            for (int j=0; j<col; j++){
                matrix2[i][j] = keyboard.nextInt();
                matrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }

        System.out.println("Sum:");
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
