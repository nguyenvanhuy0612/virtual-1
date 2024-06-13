package com.codility.app.lession1;

public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.solution(9));
        System.out.println(binaryGap.solution(529));
        System.out.println(binaryGap.solution(20));
        System.out.println(binaryGap.solution(32));
        System.out.println(binaryGap.solution(1041));
    }

    public int solution(int N) {
        char[] binaryChars = Integer.toBinaryString(N).toCharArray();
        int maxGap = 0;  // Length of the longest binary gap
        int lastOneIndex = -1;   // Index of the previous '1'

        for (int i = 0; i < binaryChars.length; i++) {
            if (binaryChars[i] == '1') {
                if (lastOneIndex != -1) {
                    // Calculate the gap length
                    int gapLength = i - lastOneIndex - 1;
                    if (gapLength > maxGap) {
                        maxGap = gapLength;
                    }
                }
                lastOneIndex = i;  // Update the last '1' position to the current index
            }
        }
        return maxGap;
    }

    public int solution_o1(int N) {
        char[] chars = Integer.toBinaryString(N).toCharArray();
        int len = 0;
        int s = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '1') {
                int d = i - s - 1;
                if (d > len) {
                    len = d;
                }
                s = i;
            }
        }
        return len;
    }
}
