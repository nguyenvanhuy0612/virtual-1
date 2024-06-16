package com.codility.app.session2;

import java.util.*;

public class Task2_1 {
    public static void main(String[] args) {
        Task2_1 sol = new Task2_1();
        System.out.println(sol.solution(new int[]{1, 4, 1}, new int[]{1, 5, 1})); // should return 2
        System.out.println(sol.solution(new int[]{4, 4, 2, 4}, new int[]{5, 5, 2, 5})); // should return 3
        System.out.println(sol.solution(new int[]{2, 3, 4, 2}, new int[]{2, 5, 7, 2})); // should return 2
    }

    public int solution(int[] P, int[] S) {
        // Sum up the total number of people
        int totalPeople = 0;
        for (int people : P) {
            totalPeople += people;
        }

        // Sort the seats array in descending order
        Integer[] seats = Arrays.stream(S).boxed()
//                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);
        Arrays.sort(seats, Collections.reverseOrder());

        // Start using cars with the most seats until all people are accommodated
        int carsUsed = 0;
        int currentPeople = 0;

        for (int seat : seats) {
            currentPeople += seat;
            carsUsed++;
            if (currentPeople >= totalPeople) {
                break;
            }
        }

        return carsUsed;
    }
}
