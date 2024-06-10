package org.example;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;

        //System.out.println(Arrays.toString(solution(A, K)));
    }



    public static int[] solution2(int[] A, int K) {
        int length = A.length;
        if (length == 0 || K <= 0) {
            return A;
        }

        java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
        for (int i : A) {
            list.push(i);
        }

        K = K % length;

        for (int i = 0; i < K; i++) {
            Integer item = list.pop();
            list.addLast(item);
        }


        int size = list.size();
        for (int i = 0; i < size; i++) {
            A[i] = list.get(size - i - 1);
        }

        return A;
    }


    public static int solution1(int N) {
        // Implement your solution here
        if (N < 1 || N > 2147483647) {
            return 0;
        }

        int r = 0;
        char[] chars = Integer.toBinaryString(N).toCharArray();

        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                int distance = i - idx - 1;
                if (distance > r) {
                    r = distance;
                }
                idx = i;
            }
        }

        return r;
    }
}