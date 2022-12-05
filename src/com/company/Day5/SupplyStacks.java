package com.company.Day5;

import com.company.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SupplyStacks {


    public static String rearrangeStacks() {
        List<LinkedList<Integer>> input = getInput();
        List<int[]> moves = getMoves();
        for (int[] move : moves) {
            for (int i = 0; i < move[0]; i++) {
                Integer letter = input.get(move[1] - 1).pop();
                input.get(move[2] - 1).push(letter);
            }
        }
        return input.stream().map(stack -> Character.toString((char) stack.pop().intValue())).collect(Collectors.joining());
    }

    public static String rearrangeStacksPartTwo() {
        List<LinkedList<Integer>> input = getInput();
        List<int[]> moves = getMoves();
        for (int[] move : moves) {
            int[] letters = new int[move[0]];
            for (int i = 0; i < move[0]; i++) {
                letters[i] = input.get(move[1] - 1).pop();
            }
            for (int i = move[0]; i > 0; i--) {
                input.get(move[2] - 1).push(letters[i-1]);
            }
        }
        return input.stream().map(stack -> Character.toString((char) stack.pop().intValue())).collect(Collectors.joining());
    }

    public static List<LinkedList<Integer>> getInput() {
        List<LinkedList<Integer>> stacks = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            LinkedList<Integer> s = new LinkedList<>();
            switch (i) {
                case 1 -> "RGJBTVZ".chars().forEach(s::push);
                case 2 -> "JRVL".chars().forEach(s::push);
                case 3 -> "SQF".chars().forEach(s::push);
                case 4 -> "ZHNLFVQG".chars().forEach(s::push);
                case 5 -> "RQTJCSMW".chars().forEach(s::push);
                case 6 -> "SWTCHF".chars().forEach(s::push);
                case 7 -> "DZCVFNJ".chars().forEach(s::push);
                case 8 -> "LGZDWRFQ".chars().forEach(s::push);
                case 9 -> "JBWVP".chars().forEach(s::push);
            }
            stacks.add(s);
        }
        return stacks;
    }

    public static List<int[]> getMoves() {
        List<String> moveInput = Main.readInput("src/com/company/Day5/moves.txt");
        return moveInput.stream()
                .map(line -> Arrays.stream(line.split(" "))
                        .filter(s -> s.matches("^[0-9]*$"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(rearrangeStacks());
        System.out.println(rearrangeStacksPartTwo());
    }
}
