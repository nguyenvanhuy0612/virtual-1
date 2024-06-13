package com.codility.app.lession3;

public class FrogJmp {
    public static void main(String[] args) {
        FrogJmp sol = new FrogJmp();

        // Test cases
        System.out.println(sol.solution(10, 85, 30));  // Output: 3
        System.out.println(sol.solution(10, 70, 30));  // Output: 2
        System.out.println(sol.solution(10, 10, 30));  // Output: 0
        System.out.println(sol.solution(10, 40, 10));  // Output: 3
    }

    public int solution(int X, int Y, int D) {
        int d = Y - X;
        int n = d / D;
        return d % D == 0 ? n : n + 1;
    }

    public int solution_o(int X, int Y, int D) {
        // Calculate the distance to cover
        int distanceToCover = Y - X;

        // Calculate the minimal number of jumps needed
        int jumps = (distanceToCover + D - 1) / D;

        return jumps;
    }
}
