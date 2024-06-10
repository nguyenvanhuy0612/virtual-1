package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int solution(int N) {
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