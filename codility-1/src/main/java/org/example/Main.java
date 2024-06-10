package org.example;


import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //int[] A = {3, 8, 9, 7, 6};
        //int K = 3;
        //System.out.println(Arrays.toString(solution(A, K)));

//        int[] A = {9, 3, 9, 3, 9, 7, 9};
//        System.out.println(solution(A));

//        int X = 10;
//        int Y = 85;
//        int D = 30;
//        System.out.println(solution31(X, Y, D));

//        int[] A = {2, 3, 1, 5};
//        System.out.println(solution32(A));

//        int[] A = {2, 3, 1, 5};
//        System.out.println(solution33(A));

        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        int X = 5;
        System.out.println(solution41(X, A));
    }

    public static int solution41(int X, int[] A) {
        java.util.Set<Integer> set = new java.util.HashSet<>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if (set.size() == X) {
                return i;
            }
        }

        return -1;
    }

    public static int solution33(int[] A) {
        int totalSum = 0;

        if (A.length == 1) {
            return A[0];
        }

        for (int num : A) {
            totalSum += num;
        }

        int minDifference = Integer.MAX_VALUE;
        int leftSum = 0;

        for (int P = 1; P < A.length; P++) {
            leftSum += A[P - 1];
            int rightSum = totalSum - leftSum;
            int difference = Math.abs(leftSum - rightSum);
            minDifference = Math.min(minDifference, difference);
        }

        return minDifference;
    }

    public static int solution32(int[] A) {
        int length = A.length;
        if (length == 0) {
            return 1;
        }

        java.util.Arrays.sort(A);

        for (int i = 0; i < length; i++) {
            int item = A[i];

            if (item - i > 1) {
                return ++i;
            }
        }

        return length + 1;
    }

    public static int solution31(int X, int Y, int D) {
        int dis = Y - X;
        int num = dis / D;
        if (dis % D != 0) {
            num++;
        }
        return num;
    }

    public static int solution22(int[] A) {
        java.util.Map<Integer, Integer> countMap = new java.util.HashMap<>();

        for (int i : A) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        for (java.util.Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }

        throw new RuntimeException("Invalid input array: No unpaired element found");
    }


    public static int[] solution21(int[] A, int K) {
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