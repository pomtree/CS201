// delete this line if this is not in a folder called lab1
package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Diagonal {

    /**
     * Returns the absolute value of the difference between the diagonals of a matrix.
     * <p>
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * <p>
     * Should return abs((1+5+9) - (3+5+7)) = 0
     */

    public static int diagonalDifference(int[][] matrix)
    {
        int sum1 = 0, sum2 = 0;
        for(int y = 0; y < matrix.length; y++) {
            sum1 += matrix[y][y];
            sum2 += matrix[y][matrix.length - y - 1];
        }
        return Math.abs(sum1 - sum2);
    }

    /**
     * Reads a file and returns an array of arrays of ints
     *
     * @param filename
     * @return
     */
    public static int[][] readMatrixFromFilename(String filename) throws FileNotFoundException {
        // Read file into List of strings
        Scanner scanner = new Scanner(new File(filename));
        int lines = 0;
        while (scanner.hasNextLine()) {
            lines++;
            scanner.nextLine();
        }
        scanner = new Scanner(new File(filename));

        int[][] matrix = new int[lines][lines];

        for (int y = 0; scanner.hasNextLine(); y++) {
            for (int i = 0; i < lines; i++) {
                matrix[y][i] = scanner.nextInt();
            }
            if (y != lines - 1) scanner.nextLine();

        }


        // Determine size of array, create int[][]

        // Turn each string into an array of ints
        return matrix;
    }

    public static void main(String[] args) throws IOException {

        //String filename = args[0];
        String filename = "C:\\Users\\user\\Desktop\\matrix1.txt";
        int[][] matrix = readMatrixFromFilename(filename);
        int diff = diagonalDifference(matrix);
        System.out.println("The difference is: " + diff);

    }
}
