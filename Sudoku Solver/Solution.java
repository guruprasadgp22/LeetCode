class Solution {
    public void solveSudoku(char[][] board) {
        int row = 0;
        int col = 0;

        boolean ans = solve(board, row, col);
    }

    public boolean solve(char[][] board, int row, int col){
        if(row == 9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;

        if(nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if(board[row][col] != '.') {
            return solve(board, nextRow, nextCol);
        }

        for(char dig = '1'; dig <= '9'; dig++) {
            if(isSafe(board, row, col, dig)) {
                board[row][col] = dig;

                if(solve(board,nextRow, nextCol)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char dig) {
        for(int i=0;i<9;i++) {
            if(board[row][i] == dig) {
                return false;
            }
        }

        for(int i=0;i<9;i++) {
            if(board[i][col] == dig) {
                return false;
            }
        }

        int startRow = (row/3)*3;
        int startCol = (col/3)*3;

        for(int i=startRow; i <= startRow+2; i++) {
            for(int j=startCol; j<=startCol+2; j++) {
                if(board[i][j] == dig) {
                    return false;
                }
            }
        }

        return true;
    }
}
