package com.codility.app.lession4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxCounters {
    public static void main(String[] args) {

    }

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int currentMax = 0;  // Current maximum value of any counter
        int maxToApply = 0;  // Value to apply to all counters at next increase operation

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                int index = A[i] - 1;  // Convert to 0-based index

                // Ensure the counter is updated to at least maxToApply before incrementing
                if (counters[index] < maxToApply) {
                    counters[index] = maxToApply;
                }

                // Increment the counter
                counters[index]++;

                // Update the current max if needed
                if (counters[index] > currentMax) {
                    currentMax = counters[index];
                }
            } else if (A[i] == N + 1) {
                // Update the maxToApply to the current max
                maxToApply = currentMax;
            }
        }

        // Ensure all counters are at least maxToApply
        for (int i = 0; i < N; i++) {
            if (counters[i] < maxToApply) {
                counters[i] = maxToApply;
            }
        }

        return counters;
    }

    public int[] solution_h(int N, int[] A) {
        int[] counters = new int[N];
        //Arrays.fill(counters, 0);

        for (int a : A) {
            if (a >= 1 && a <= N) {
                int i = a - 1;
                counters[i]++;
            } else if (a == N + 1) {
                Arrays.parallelSort(counters);
                int max = counters[N-1];
                Arrays.fill(counters, max);
            }
        }

        return counters;
    }
}
