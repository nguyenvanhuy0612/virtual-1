package com.codility.app.session2.Task1;

/*

Write a function solution that, given integer N, returns the smallest non-negative integer whose individual digits sum to N.

Examples:

1. Given N = 16, the function should return 79. There are many numbers whose digits sum to 16 (for example: 79, 97, 808, 5551, 22822, etc.). The smallest such number is 79.

2. Given N = 19, the function should return 199 (the sum of digits is 1 + 9 + 9 = 19).

3. Given N = 7, the function should return 7.

Assume that:

N is an integer within the range [0..50].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.


 */
public class Solution {
    public int solution(int N) {
        if (N == 0) {
            return 0;
        }

        // To store digits of the resulting number
        StringBuilder result = new StringBuilder();

        // Process the number to break down N into digits
        while (N > 0) {
            // Choose the largest possible digit (max is 9)
            int digit = Math.min(N, 9);
            // Append the digit to the front of the result
            result.insert(0, digit);
            // Subtract the chosen digit from N
            N -= digit;
        }

        // Convert the result to an integer
        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(16)); // should return 79
        System.out.println(sol.solution(19)); // should return 199
        System.out.println(sol.solution(7));  // should return 7
    }
}

