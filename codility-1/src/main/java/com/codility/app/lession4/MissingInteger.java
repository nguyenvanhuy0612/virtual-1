package com.codility.app.lession4;

public class MissingInteger {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        // Step 1: Create a set to store positive integers
        java.util.Set<Integer> positiveNumbers = new java.util.HashSet<>();

        // Step 2: Add only positive integers to the set
        for (int num : A) {
            if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        // Step 3: Find the smallest missing positive integer
        int smallestMissingPositive = 1;
        while (positiveNumbers.contains(smallestMissingPositive)) {
            smallestMissingPositive++;
        }

        // Return the result
        return smallestMissingPositive;
    }

    public int solution_h(int[] A) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        if (set.size() == 0) {
            return 1;
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 1;
    }
}
