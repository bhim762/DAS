class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Step 1: encode next state
        // 0 = dead->dead, 1 = live->live, 2 = live->dead, 3 = dead->live
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                for (int d = 0; d < 8; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        if (board[ni][nj] == 1 || board[ni][nj] == 2) {
                            liveNeighbors++;
                        }
                    }
                }

                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2; // live -> dead
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 3; // dead -> live
                }
            }
        }

        // Step 2: decode final state (2 -> 0, 3 -> 1, others unchanged)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}