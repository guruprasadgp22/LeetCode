class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        int row = 0;
        nQueenSolver(board, row, n, result);
        return result;
    }

    public void nQueenSolver(char[][] board, int row, int n, List<List<String>> result) {
        if(row == n) {
            List<String> ans = new ArrayList<>();
            for(int i=0;i<n;i++) {
                ans.add(new String(board[i]));
            }

            result.add(ans);
            return;
        }

        for(int i=0;i<n;i++) {
            if(isSafe(board, row, i, n)) {
                board[row][i] = 'Q';
                nQueenSolver(board, row+1, n, result);
                board[row][i] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col, int n) {
        for(int i=0;i<n;i++) {
            if(board[row][i] =='Q') {
                return false;
            }
        }

        for(int i=0;i<n;i++) {
            if(board[i][col] =='Q') {
                return false;
            }
        }

        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i=row, j=col; i>=0 &&  j< n; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
