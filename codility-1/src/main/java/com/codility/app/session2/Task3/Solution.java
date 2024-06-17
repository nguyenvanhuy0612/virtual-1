package com.codility.app.session2.Task3;

/*

We are given a two-dimensional board of size N × M (N rows and M columns). Each field of the board can be empty ('.'), may contain an obstacle ('X') or may have a character in it. The character might be either an assassin ('A') or a guard. Each guard stands still and looks straight ahead, in the direction they are facing.

Every guard looks in one of four directions (up, down, left or right on the board) and is represented by one of four symbols. A guard denoted by '<' is looking to the left; by '>', to the right; '^', up; or 'v', down. The guards can see everything in a straight line in the direction in which they are facing, as far as the first obstacle ('X' or any other guard) or the edge of the board.

The assassin can move from the current field to any other empty field with a shared edge. The assassin cannot move onto fields containing obstacles or enemies.

Write a function:

class Solution { public boolean solution(String[] B); }

that, given an array B consisting of N strings denoting rows of the array, returns true if is it possible for the assassin to sneak from their current location to the bottom-right cell of the board undetected, and false otherwise.

Examples:

1. Given B = ["X.....>", "..v..X.", ".>..X..", "A......"], your function should return false. All available paths lead through a field observed by a guard.

Graphical representation of the first example

2. Given B = ["...Xv", "AX..^", ".XX.."], your function should return true. The guard in the second row is blocking the other one from watching the bottom-right square.

Graphical representation of the second example

3. Given B = ["...", ">.A"], your function should return false, as the assassin gets spotted right at the start.

Graphical representation of the third example

4. Given B = ["A.v", ..."], your function should return false. It's not possible for the assassin to enter the bottom-right cell undetected, as the cell is observed.

Graphical representation of the fourth example

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..500];
all strings in B are of the same length M from range [1..500];
there is exactly one assassin on the board;
there is no guard or wall on B[N−1][M−1];
every string in B consists only of the following characters '.', 'X', '<', '>', 'v', '^' and/or 'A'.
 */

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution_t(new String[]{"X.....>", "..v..X.", ".>..X..", "A......"})); // false
        System.out.println(sol.solution_t(new String[]{"...Xv", "AX..^", ".XX.."})); // true
        System.out.println(sol.solution_t(new String[]{"...", ">.A"})); // false
        System.out.println(sol.solution_t(new String[]{"A.v"})); // false
    }

    public boolean solution_t(String[] B) {
        int N = B.length;
        int M = B[0].length();

        char[][] board = new char[N][M];
        int startX = -1, startY = -1;

        for (int i = 0; i < N; i++) {
            board[i] = B[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'A') {
                    startX = i;
                    startY = j;
                }
            }
        }

        // all observed, fill 'O'
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char cell = board[i][j];
                if (cell == '<' || cell == '>' || cell == '^' || cell == 'v') {
                    // directions
                    int dx = 0;
                    int dy = 0;
                    if (cell == '<') {
                        // right
                        dy = -1;
                    } else if (cell == '>') {
                        // left
                        dy = 1;
                    } else if (cell == '^') {
                        // up
                        dx = -1;
                    } else if (cell == 'v') {
                        // down
                        dx = 1;
                    }

                    int x = i + dx;
                    int y = j + dy;
                    //char nextCell = board[x][y];

                    while (x >= 0
                            && y >= 0
                            && x < N
                            && y < M
                            && board[x][y] != 'X'
                            && board[x][y] != '<'
                            && board[x][y] != '>'
                            && board[x][y] != '^'
                            && board[x][y] != 'v'
                    ) {
                        if (board[x][y] == 'A') {
                            return false;
                        }
                        if (board[x][y] == '.') {
                            board[x][y] = 'O'; // fill to 'O' as cannot run to this cell
                        }
                        // update x,y
                        x = x + dx;
                        y = y + dy;
                    }
                }
            }
        }

        // check 'A' is 'O' ?
//        if (board[startX][startY] == 'O') {
//            return false;
//        }

        // find path from (startX, startY) to (N-1, M-1)
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.add(new int[]{startX, startY});

        boolean[][] visit = new boolean[N][M];
        visit[startX][startY] = true;

        //  right{0,1}, down{1,0}, left{0,-1}, up{-1,0}
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];

            if (x == N - 1 && y == M - 1) {
                return true; //end
            }

            for (int[] d : directions) {
                int dx = x + d[0];
                int dy = y + d[1];

                if (dx >= 0
                        && dy >= 0
                        && dx < N
                        && dy < M
                        && visit[dx][dy] != true
                        && board[dx][dy] == '.'
                    // && board[dx][dy] != 'O'
                ) {
                    visit[dx][dy] = true;
                    queue.add(new int[]{dx, dy});
                }
            }
        }

        return false;
    }

    public boolean solution_h(String[] B) {
        int N = B.length;
        int M = B[0].length();

        char[][] board = new char[N][M];
        int startX = -1, startY = -1;

        // Convert the input to a 2D char array and locate the assassin
        for (int i = 0; i < N; i++) {
            board[i] = B[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'A') {
                    startX = i;
                    startY = j;
                }
            }
        }

        // Directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Mark cells observed by guards
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char cell = board[i][j];
                if (cell == '<' || cell == '>' || cell == '^' || cell == 'v') {
                    int dx = 0, dy = 0;
                    if (cell == '<') dy = -1;
                    else if (cell == '>') dy = 1;
                    else if (cell == '^') dx = -1;
                    else if (cell == 'v') dx = 1;

                    int x = i + dx, y = j + dy;
                    while (x >= 0
                            && x < N
                            && y >= 0
                            && y < M
                            && board[x][y] != 'X'
                            && board[x][y] != '<'
                            && board[x][y] != '>'
                            && board[x][y] != '^'
                            && board[x][y] != 'v') {
                        if (board[x][y] == '.' || board[x][y] == 'A') {
                            board[x][y] = 'O';  // Mark as observed
                        }
                        x += dx;
                        y += dy;
                    }
                }
            }
        }

        // Check if the assassin starts in an observed cell
        if (board[startX][startY] == 'O') {
            return false;
        }

        // BFS to find path from (startX, startY) to (N-1, M-1)
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

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0
                        && nx < N
                        && ny >= 0
                        && ny < M
                        && !visited[nx][ny]
                        && board[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}

