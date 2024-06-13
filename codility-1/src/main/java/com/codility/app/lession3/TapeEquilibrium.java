package com.codility.app.lession3;

public class TapeEquilibrium {
    public static void main(String[] args) {
        TapeEquilibrium sol = new TapeEquilibrium();

        // Test case
        int[] A = {3, 1, 2, 4, 3};
        System.out.println(sol.solution(A));  // Output: 1
    }

    public int solution(int[] A) {
        int N = A.length;

        // Calculate total sum of array A
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        // Initialize variables
        int leftSum = 0;
        int rightSum = totalSum;
        int minDifference = Integer.MAX_VALUE;

        // Iterate through the array to find the minimal difference
        for (int i = 0; i < N - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            int difference = Math.abs(leftSum - rightSum);
            if (difference < minDifference) {
                minDifference = difference;
            }
        }

        return minDifference;
    }
}
