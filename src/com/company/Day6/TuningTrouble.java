package com.company.Day6;

import com.company.Main;

import java.util.*;

public class TuningTrouble {

    public static int getStartOfPacketMarker(String input) {
        // window of 4 characters
        int start = 0, end = 3;
        Map<Character, Integer> letters = new HashMap<>();
        char[] chars = input.toCharArray();
        while (start <= end && end < input.length()) {
            if (!letters.containsKey(chars[start])){
                letters.put(chars[start], start);
            }
            else {
                start = letters.get(chars[start]);
                end = start + 4;
                letters.clear();
            }
            start++;
        }
        return start;
    }

    public static int getStartOfPacketMarkerPartTwo(String input) {
        // window of 14 characters
        int start = 0, end = 13;
        Map<Character, Integer> letters = new HashMap<>();
        char[] chars = input.toCharArray();
        while (start <= end && end < input.length()) {
            if (!letters.containsKey(chars[start])){
                letters.put(chars[start], start);
            }
            else {
                start = letters.get(chars[start]);
                end = start + 14;
                letters.clear();
            }
            start++;
        }
        return start;
    }

    public static void main(String[] args) {
        String input = Main.readInput("src/com/company/Day6/buffer.txt").get(0);
        System.out.println(getStartOfPacketMarker(input));
        System.out.println(getStartOfPacketMarkerPartTwo(input));
    }
}
