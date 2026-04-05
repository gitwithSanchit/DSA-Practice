package Recursion;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {

        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                if (board[row][col] == '.') {

                    for char c = '1'; c < '9'; c++) {

                        if (isSafe(row, col, board, c)) {

                            board[row][col] = c;

                            if (solve(board)) return true;

                            board[row][col] = '.';
                        }
                    }
                    return false;  //no number worked
                }
            }
        }
        return true;    // Sudoku solved
    }

    private boolean isSafe(int row, int col, char[][] board, char k) {

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k)
                return false;
        }

        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == k)
                    return false;
            }
        }

        return true;
    }
}
