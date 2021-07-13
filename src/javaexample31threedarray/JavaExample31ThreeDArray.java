package javaexample31threedarray;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExample31ThreeDArray {

    public static void main(String[] args) {

        int[][][] a = new int[][][]{
            {{1, 2, 3}, {4, 5}, {6, 7, 8, 9, 10}},
            {{11, 12, 13, 14, 15, 16, 17}, {18, 19, 20}},
            {{21, 22, 23, 24, 25}, {26, 27, 28, 29}, {30}},
            {{31, 32, 33, 34, 35}, {36, 37, 38, 39}, {40, 41, 42}, {43, 44}}
        };
        Print3DArray(a);
        System.out.println();

        Scanner in = new Scanner(System.in);

        int[][][] arr3D = Enter3DimArray(in);
        Print3DArray(arr3D);

    }// end main 

    private static int[][][] Enter3DimArray(Scanner input) {
        System.out.print("Enter the number of rows: ");
        int rows = GetPositiveNonZeroInt(input);

        int[][][] res = new int[rows][][];

        for (int i = 0; i < res.length; i++) {
            res[i] = Get2DimArray(input);
        }
        System.out.println();
        return res;
    }

    private static int[][] Get2DimArray(Scanner input) {
        System.out.print("Enter the number of columns: ");
        int cols = GetPositiveNonZeroInt(input);

        int[][] res = new int[cols][];
        for (int i = 0; i < res.length; i++) {
            res[i] = Get1DimArray(input);
        }
        System.out.println();
        return res;
    }

    private static int[] Get1DimArray(Scanner input) {
        System.out.print("Enter the number of high: ");
        int high = GetPositiveNonZeroInt(input);

        int[] res = new int[high];

        System.out.println("Now enter the items. One item per line....");
        for (int i = 0; i < res.length; i++) {
            res[i] = GetPositiveNonZeroInt(input);
        }
        System.out.println();
        return res;
    }

    //==========================================================================
    //==========================================================================
    private static int GetPositiveNonZeroInt(Scanner input) {
        int res = 0;
        try {
            res = input.nextInt();
            if (res <= 0) {
                throw new InputMismatchException("Zero or negative number!");
            }
            input.nextLine();
            return res;
        } catch (Exception e) {
            input.nextLine();
            System.out.print("Re-enter a valid number: ");
            return GetPositiveNonZeroInt(input);
        }
    }

    private static void Print3DArray(int[][][] array) {
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                for (int k = 0; k < array[i][j].length; k++) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("---------------------------------------------");
        }
    }// end Print3DArray()

}
