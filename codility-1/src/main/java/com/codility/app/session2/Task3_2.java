package com.codility.app.session2;

import java.util.LinkedList;
import java.util.Queue;

public class Task3_2 {
    public static void main(String[] args) {
        Task3_2 sol = new Task3_2();
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
                    if (cell == '<') {
                        dx = 0;
                        dy = -1;
                    } else if (cell == '>') {
                        dx = 0;
                        dy = 1;
                    } else if (cell == '^') {
                        dx = -1;
                        dy = 0;
                    } else if (cell == 'v') {
                        dx = 1;
                        dy = 0;
                    }

                    int x = i + dx, y = j + dy;
                    while (x >= 0 && x < N && y >= 0 && y < M && board[x][y] != 'X' && board[x][y] != '<' && board[x][y] != '>' && board[x][y] != '^' && board[x][y] != 'v') {
                        if (board[x][y] == 'A') {
                            return false; // observed to A
                        }
                        if (board[x][y] == '.') {
                            board[x][y] = 'O';  // Mark as observed
                        }
                        x += dx;
                        y += dy;
                    }
                }
            }
        }

        // BFS to find path from (startX, startY) to (N-1, M-1)
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
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

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && board[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}
