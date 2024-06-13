package com.codility.app.lession2;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        OddOccurrencesInArray sol = new OddOccurrencesInArray();

        // Test cases
        int[] A1 = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(sol.solution(A1));  // Output: 7

        int[] A2 = {1, 2, 3, 2, 3, 1, 4};
        System.out.println(sol.solution(A2));  // Output: 4

        int[] A3 = {42};
        System.out.println(sol.solution(A3));  // Output: 42
    }

    public int solution(int[] A) {
        // Sort the array
        java.util.Arrays.sort(A);

        // Traverse the sorted array to find the unpaired element
        for (int i = 0; i < A.length; i += 2) {
            // If it's the last element or it doesn't match the next element
            if (i == A.length - 1 || A[i] != A[i + 1]) {
                return A[i];
            }
        }

        // Should never reach here if input constraints are met
        throw new IllegalArgumentException("No unpaired element found");
    }

    public int solution_o1(int[] A) {
        int unpaired = 0;

        for (int num : A) {
            unpaired ^= num; // XOR operator
        }

        return unpaired;
    }
}
