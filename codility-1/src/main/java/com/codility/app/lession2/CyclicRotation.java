package com.codility.app.lession2;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {
        CyclicRotation rotation = new CyclicRotation();
        System.out.println(Arrays.toString(
                rotation.solution(new int[]{3, 8, 9, 7, 6}, 3)));

        int[] A = {3, 8, 9, 7, 6};
        int K = 3;

        int[] rotatedA = rotation.solution(A, K);
        System.out.println(Arrays.toString(rotatedA));
    }

    public int[] solution(int[] A, int K) {
        int N = A.length;

        // Handle edge cases
        if (N == 0 || K == 0) {
            return A;
        }

        // Effective rotations needed
        K = K % N;
        if (K == 0) {
            return A;
        }

        // Create a new array for the result
        int[] rotatedArray = new int[N];

        // Copy the last K elements to the beginning
        System.arraycopy(A, N - K, rotatedArray, 0, K);

        // Copy the rest of the elements to the new array
        System.arraycopy(A, 0, rotatedArray, K, N - K);

        return rotatedArray;
    }
}
