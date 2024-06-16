package com.codility.app.lession5;

public class PassingCars {
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 0, 1, 1};
        solution(A);
    }

    public static int solution(int[] A) {
        int eastCount = 0;
        int passingCount = 0;
        final int LIMIT = 1000000000;
        // 0 1 1 1 0 1

        for (int car : A) {
            if (car == 0) {
                // Car traveling east
                eastCount++;
            } else if (car == 1) {
                // Car traveling west
                passingCount += eastCount;
                if (passingCount > LIMIT) {
                    return -1;
                }
            }
        }

        return passingCount;
    }

    public int solution_h(int[] A) {
        int pair = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                continue;
            }
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] == 1) {
                    pair++;
                }
            }
        }

        return pair > 1_000_000_000 ? -1 : pair;
    }
}
