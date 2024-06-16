package com.codility.app.session2;


public class Task3_1 {
    private static final char OBSTACLE = 'X';
    private static final char ASSASSIN = 'A';
    private static final char EMPTY = '.';
    private static final char LEFT = '<';
    private static final char RIGHT = '>';
    private static final char UP = '^';
    private static final char DOWN = 'v';
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // right, down, left, up

    public static void main(String[] args) {
        Task3_1 sol = new Task3_1();
        System.out.println(sol.solution(new String[]{"X.....>", "..v..X.", ".>..X..", "A......"})); // false
        System.out.println(sol.solution(new String[]{"...Xv", "AX..^", ".XX.."})); // true
        System.out.println(sol.solution(new String[]{"...", ">.A"})); // false
        System.out.println(sol.solution(new String[]{"A.v"})); // false
    }

    public boolean solution(String[] B) {
        int N = B.length;
        int M = B[0].length();

        char[][] board = new char[N][M];
        int startX = -1, startY = -1;

        // Convert the input to a 2D char array and locate the assassin
        for (int i = 0; i < N; i++) {
            board[i] = B[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == ASSASSIN) {
                    startX = i;
                    startY = j;
                }
            }
        }

        // Mark cells observed by guards
        markGuardObservations(board, N, M);

        // Check A is O
        if (board[startX][startX] == 'O') {
            return false;
        }

        // BFS to find path from (startX, startY) to (N-1, M-1)
        return bfs(board, startX, startY, N, M);
    }

    private void markGuardObservations(char[][] board, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char cell = board[i][j];
                if (cell == LEFT || cell == RIGHT || cell == UP || cell == DOWN) {
                    markDirection(board, N, M, i, j, cell);
                }
            }
        }
    }

    private void markDirection(char[][] board, int N, int M, int x, int y, char direction) {
        int dx = 0, dy = 0;

        switch (direction) {
            case LEFT:
                dy = -1;
                break;
            case RIGHT:
                dy = 1;
                break;
            case UP:
                dx = -1;
                break;
            case DOWN:
                dx = 1;
                break;
        }

        x += dx;
        y += dy;

        while (x >= 0
                && x < N
                && y >= 0
                && y < M
                && board[x][y] != OBSTACLE
                && board[x][y] != LEFT
                && board[x][y] != RIGHT
                && board[x][y] != UP
                && board[x][y] != DOWN) {
            if (board[x][y] == EMPTY || board[x][y] == ASSASSIN) {
                board[x][y] = 'O';  // Mark as observed
            }
            x += dx;
            y += dy;
        }
    }

    private boolean bfs(char[][] board, int startX, int startY, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            if (x == N - 1 && y == M - 1) {
                return true;  // Reached the bottom-right corner
            }

            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0
                        && nx < N
                        && ny >= 0
                        && ny < M
                        && !visited[nx][ny]
                        && board[nx][ny] == EMPTY) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}
