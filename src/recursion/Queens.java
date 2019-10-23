package recursion;

public class Queens {
    // Example of recursion for puzzle solving: find a chess board with as
// many queens as rows/columns where none threatens another.
    public static final int SIZE = 8;

    // Blank out a chessboard. Use a hyphen to indicate no piece
    public static void initBoard(char[][] board) {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = '-';
    }

    // Copy a chessboard.
    public static char[][] copyBoard(char[][] board) {
        char[][] copy = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                copy[i][j] = board[i][j];
        return copy;
    }

    // Display a chessboard to the terminal window.
    public static void displayBoard(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    // Check to see if a potential location (row, col) on the board is
    // "safe", which means that it cannot be taken by a queen already
    // on the board.
    public static boolean safe(char[][] board, int row, int col) {
        int i, j;

        // Check column
        for (i = 0; i < SIZE; i++)
            if (board[i][col] == 'Q')
                return false;

        // Check row
        for (j = 0; j < SIZE; j++)
            if (board[row][j] == 'Q')
                return false;

        // Check diagonal down and right
        for (i = row, j = col; i < SIZE && j < SIZE; i++, j++)
            if (board[i][j] == 'Q')
                return false;

        // Check diagonal up and left

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Check diagonal up and right

        for (i = row, j = col; i >= 0 && j < SIZE; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        // Check diagonal down and left

        for (i = row, j = col; i < SIZE && j > 0; i++, j--)
            if (board[i][j] == 'Q')
                return false;

        // Must be safe
        return true;
    }

    // completeBoard fills in the board with a successful set of
    // queens and returns a filled in board if it can be done,
    // otherwise it returns null
    public static char[][] completeBoard(char[][] board) {
        // Count queens, return if complete

        // If not eight queens, must be fewer: try to add another
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (safe(board, i, j)) {
                    char[][] copy = copyBoard(board);
                    copy[i][j] = 'Q';

                    char[][] result = completeBoard(copy);
                    if (result != null) {
                        //displayBoard(result);
                        completeBoard(result);
                        board = result;
                    }
                }
            }
        }
        int numQueens = 0;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == 'Q')
                    numQueens++;

        if (numQueens == SIZE)
            return board;


        // Failed to find solution
        //displayBoard(board);
        return null;
    }

    public static void main(String[] args) {
        char[][] board = new char[SIZE][SIZE];
        initBoard(board);
        char[][] result = completeBoard(board);

        if (result != null)
            displayBoard(result);
        else
            System.out.println("Failed.");
    }
}


