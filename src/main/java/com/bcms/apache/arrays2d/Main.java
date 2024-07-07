package com.bcms.apache.arrays2d;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] myArray = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + " ");
            }
        }
        //mesmo que: Complexidade de tempo: O(m * n); Complexidade do espaço: O(1).
        System.out.println();
        Arrays.stream(myArray)
                .flatMapToInt(Arrays::stream)
                .forEach(num -> System.out.print(num + " "));
    }
}
