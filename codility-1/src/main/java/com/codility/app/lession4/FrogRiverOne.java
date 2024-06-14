package com.codility.app.lession4;

public class FrogRiverOne {
    public static void main(String[] args) {

    }

    public int solution(int X, int[] A) {
        java.util.Set<Integer> positionsCovered = new java.util.HashSet<>();

        for (int time = 0; time < A.length; time++) {
            positionsCovered.add(A[time]);

            // Check if all positions from 1 to X are covered
            if (positionsCovered.size() == X) {
                return time;
            }
        }

        // If we reach here, it means not all positions were covered
        return -1;
    }

    public int solution_h(int X, int[] A) {
        java.util.Set<Integer> set = new java.util.HashSet<>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if (set.size() == X) {
                return i;
            }
        }

        return -1;
    }
}
