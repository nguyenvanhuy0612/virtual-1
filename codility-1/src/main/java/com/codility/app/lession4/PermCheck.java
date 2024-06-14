package com.codility.app.lession4;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        int N = A.length;
        Set<Integer> seenNumbers = new HashSet<>();

        for (int number : A) {
            if (number < 1 || number > N) {
                return 0;
            }
            seenNumbers.add(number);
        }

        return seenNumbers.size() == N ? 1 : 0;
    }

    public int solution_h(int[] A) {
        // returns 1 if array A is a permutation and 0 if it is not.
        Set<Integer> set = new HashSet<>();

        for (int i : A) {
            if (!set.add(i)) {
                return 0;
            }
        }

        if (set.size() != A.length) {
            return 0;
        }

        int sum = set.stream().mapToInt(Integer::intValue).sum();

        if (sum != A.length * (A.length + 1) / 2) {
            return 0;
        }

        return 1;
    }
}
