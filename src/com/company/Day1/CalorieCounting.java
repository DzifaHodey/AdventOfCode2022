package com.company.Day1;

import com.company.common.InputReader;

import java.util.*;

public class CalorieCounting {

    public static int countMaxCalories(List<String> input){
        int val = 0, max = 0;
        List<Integer> elfToCalories = new ArrayList<>();
        for (String line: input){
            if ("".equals(line)){
                max = Math.max(val, max);
                elfToCalories.add(val);
                val = 0;
                continue;
            }
            val += Integer.parseInt(line);
        }
        return max;
    }

    public static int getTopThreeMaxCalories(List<String> input){
        int val = 0, max = 0;
        List<Integer> elfToCalories = new ArrayList<>();
        for (String line: input){
            if ("".equals(line)){
                max = Math.max(val, max);
                elfToCalories.add(val);
                val = 0;
                continue;
            }
            val += Integer.parseInt(line);
        }
        max = Math.max(val, max);
        elfToCalories.add(val);
        Collections.sort(elfToCalories, Collections.reverseOrder());
        int topThree = 0;
        for (int i = 0; i < 3; i++){
            topThree += elfToCalories.get(i);
        }
        return topThree;
    }

    public static void main(String[] args) {
        List<String> input = InputReader.read("src/com/company/Day1/calorieInput.txt");
        System.out.println(countMaxCalories(input));
        System.out.println(getTopThreeMaxCalories(input));
    }
}
