package com.company.Day4;

import com.company.Main;

import java.util.Arrays;
import java.util.List;

public class CampCleanup {

    public static long getSubSections(List<String> input){
        return input.stream()
                .map(assignment -> assignment.replace(",", "-").split("-"))
                .map(ranges -> Arrays.stream(ranges).mapToInt(Integer::parseInt).toArray())
                .filter(ranges -> (ranges[0] <= ranges[2] && ranges[1] >= ranges[3]) || (ranges[0] >= ranges[2] && ranges[1] <= ranges[3]))
                .count();
    }

    public static long getOverlappingSections(List<String> input){
        return input.stream()
                .map(assignment -> assignment.replace(",", "-").split("-"))
                .map(ranges -> Arrays.stream(ranges).mapToInt(Integer::parseInt).toArray())
                .filter(ranges -> (ranges[0] <= ranges[3] && ranges[1] >= ranges[2]))
                .count();
    }

    public static void main(String[] args) {
        List<String> input = Main.readInput("src/com/company/Day4/sections.txt");
        System.out.println(getSubSections(input));
        System.out.println(getOverlappingSections(input));
    }
}
