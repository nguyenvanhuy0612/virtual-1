package com.codility.app.lession5;

public class CountDiv {
    public static void main(String[] args) {

    }

    public int solution(int A, int B, int K) {
        if (A > B || K <= 0) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }

        // Number of multiples of K from 1 to B
        int countUpToB = B / K;

        // Number of multiples of K from 1 to (A-1)
        int countUpToA = (A > 0) ? (A - 1) / K : -1;

        // If A is 0, we need to include the 0 as a multiple
        if (A == 0) {
            return countUpToB + 1;
        }

        return countUpToB - countUpToA;
    }

    public int solution_h(int A, int B, int K) {
        int count = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                count++;
            }
        }
        return count;
    }
}
