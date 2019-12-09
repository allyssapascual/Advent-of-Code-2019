package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        String[] arr = readInput();

        arr[1] = String.valueOf(12);
        arr[2] = String.valueOf(2);

        arr = calculatePart1(arr);

        System.out.println("Value in position 0: " + arr[0]);
    }

    public static void part2() {
        int target = 19690720;
        String[] arr;

        arr = calculatePart2(target);

        int noun = Integer.parseInt(arr[1]);
        int verb = Integer.parseInt(arr[2]);

        System.out.println("Value of 100 * noun + verb: " + (100*noun+verb));
    }

    public static String[] readInput() {
        String[] arr = null;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            arr = line.split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }

    public static String[] calculatePart1(String[] arr) {
        for (int x = 0; x < arr.length - 1; x+=4) {
            int opcode = Integer.parseInt(arr[x]);
            int firstPos = Integer.parseInt(arr[x+1]);
            int first = Integer.parseInt(arr[firstPos]);
            int secondPos = Integer.parseInt(arr[x+2]);
            int second = Integer.parseInt(arr[secondPos]);
            int third = Integer.parseInt(arr[x+3]);

            if (opcode == 1) {
                arr[third] = String.valueOf(first + second);
            } else if (opcode == 2) {
                arr[third] = String.valueOf(first * second);
            } else if (opcode == 99) {
                return arr;
            }
        }

        return arr;
    }

    public static String[] calculatePart2(int target) {
        String[] arr = new String[0];
        Boolean found = false;

        for (int a = 0; a <= 99; a++) {
            for (int b = 0; b <= 99; b++) {
                arr = readInput();

                arr[1] = String.valueOf(a);
                arr[2] = String.valueOf(b);

                for (int x = 0; x < arr.length - 1; x+=4) {
                    int opcode = Integer.parseInt(arr[x]);
                    int firstPos = Integer.parseInt(arr[x+1]);
                    int first = Integer.parseInt(arr[firstPos]);
                    int secondPos = Integer.parseInt(arr[x+2]);
                    int second = Integer.parseInt(arr[secondPos]);
                    int third = Integer.parseInt(arr[x+3]);

                    if (opcode == 1) {
                        arr[third] = String.valueOf(first + second);
                    } else if (opcode == 2) {
                        arr[third] = String.valueOf(first * second);
                    } else if (opcode == 99) {
                        if (Integer.parseInt(arr[0]) == target) {
                            found = true;
                        }
                    }
                }

                if (found) {
                    return arr;
                }
            }
        }

        return arr;
    }
}
