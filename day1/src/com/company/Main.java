package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Total fuel required: " + readInput());
    }

    static int readInput() {
        int mass = 0;
        int totalFuel = 0;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            while (line != null) {
                mass = Integer.parseInt(line);
                int temp = calculatePart1(mass);
                totalFuel += calculatePart2(temp);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalFuel;
    }

    static int calculatePart1(int mass) {
        int fuelPerMass = (mass/3)-2;
        return fuelPerMass;
    }

    static int calculatePart2(int fuel) {
        int temp = (fuel/3)-2;

        if (temp <= 0) {
            return fuel;
        } else {
            return fuel + calculatePart2(temp);
        }
    }
}
