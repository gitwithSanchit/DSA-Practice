package Recursion;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backTrack(board, word, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        //Base Condition
        if (index == word.length()) {
            return true;
        }

        //Boundary + Visited + Word Mismatch
        if (row < 0 || col < 0 || row > board.length || col > board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        //Mark
        visited[row][col] = true;

        //Explore
        boolean found =
                backTrack(board, word, row + 1, col, index + 1, visited) ||
                backTrack(board, word, row, col + 1, index + 1, visited) ||
                backTrack(board, word, row - 1, col, index + 1, visited) ||
                backTrack(board, word, row, col - 1, index + 1, visited);

        //Undo
        visited[row][col] = false;

        return found;
    }
}
