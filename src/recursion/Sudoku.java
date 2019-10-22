package recursion;

import java.util.Arrays;
import java.util.Optional;

public class Sudoku {

    int[][] values = new int[9][9];

    public Sudoku() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                values[row][col] = 0;
            }
        }
    }

    public Sudoku(int[][] v) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                values[row][col] = v[row][col];
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 9; row++) {
            sb.append(Arrays.toString(values[row]));
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean checkRow(int row, int value) {
        for (int i = 0; i < 9; i++) {
            if (values[row][i] == value)
                return false;
        }
        return true;
    }

    private boolean checkCol(int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (values[i][col] == value)
                return false;
        }
        return true;
    }

    private boolean checkBox(int row, int col, int value) {
        int bx = col / 3;
        int by = row / 3;
        for (int i = bx * 3; i < (bx + 1) * 3; i++) {
            for (int j = by * 3; j < (by + 1) * 3; j++) {
                if (values[i][j] == value)
                    return false;
            }
        }
        return true;
    }

    public boolean place(int row, int col, int value) {
        return true;
    }

    public boolean canPlace(int row, int col, int value) {
        return checkBox(row, col, value) && checkCol(col, value) && checkRow(row, value);
    }

    public static Sudoku copyBoard(Sudoku s) {
        Sudoku newBoard = new Sudoku(s.values);
        return newBoard;
    }

    public boolean isSolved() {
        return true;
    }

    //  public static Optional<Sudoku> solve(Sudoku s) {


    //  }

    public static void main(String[] args) {
        int[][] board = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };

        Sudoku s = new Sudoku(board);
        System.out.println(s);
        //Sudoku r = solve(s).get();
       // System.out.println(r);

    }
}