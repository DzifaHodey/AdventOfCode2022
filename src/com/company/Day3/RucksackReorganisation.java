package com.company.Day3;

import com.company.common.InputReader;

import java.util.List;
import java.util.stream.IntStream;

public class RucksackReorganisation {

    public static int reorganise(List<String> rucksacks) {
        /*
        split items into 2 compartments
        add items to a hashmap for compartment 1
        check if any item in compartment 2 is already in compartment 1, then compute the priority.
            Lowercase item types a through z have priorities 1 through 26.
            Uppercase item types A through Z have priorities 27 through 52.
        */

        return rucksacks.stream()
                .map(rucksack -> new String[]{rucksack.substring(0, rucksack.length() / 2), rucksack.substring(rucksack.length() / 2)})
                .mapToInt(compartments -> getPriorities(compartments[0])
                        .filter(c1 -> getPriorities(compartments[1]).anyMatch(c2 -> c2 == c1))
                        .findFirst()
                        .getAsInt())
                .sum();
    }

    public static int findBadge(List<String> rucksacks) {
        String[] sacks = rucksacks.toArray(String[]::new);
        return IntStream
                .range(0, rucksacks.size() / 3)
                .map(i -> i * 3)    // get every 3 iterations eg: if x is 0, starting index is 0 & if x is 1, starting index is 3
                .map(i -> getPriorities(sacks[i])
                        .filter(e1 -> getPriorities(sacks[i + 1]).anyMatch(e2 -> e2 == e1) && getPriorities(sacks[i + 2]).anyMatch(e3 -> e3 == e1))
                        .findFirst()
                        .getAsInt())
                .sum();
    }

    public static IntStream getPriorities(String s) {
        return s.chars().map(c -> Character.isLowerCase(c) ? c - 'a' + 1 : c - 'A' + 27);
    }

    public static void main(String[] args) {
        List<String> rucksacks = InputReader.read("src/com/company/Day3/items.txt");
        System.out.println(reorganise(rucksacks));
        System.out.println(findBadge(rucksacks));
    }


    // PART ONE
    /* // OLD APPROACH
        AtomicInteger totalPriorities = new AtomicInteger();
        for (String rucksack : rucksacks){
            System.out.println("Rucksack "+ rucksacks.indexOf(rucksack));
            String compartmentOne = rucksack.substring(0, rucksack.length() / 2);
            String compartmentTwo = rucksack.substring(rucksack.length() / 2);
            Map<Character, Integer> charsToCompartment = new HashMap<>();
            for (int itemIndex =0; itemIndex < compartmentOne.length(); itemIndex ++){
                if (!charsToCompartment.containsKey(compartmentOne.charAt(itemIndex))){
                    charsToCompartment.put(compartmentOne.charAt(itemIndex), 1);
                }
            }
            for (int itemIndex =0; itemIndex < compartmentTwo.length(); itemIndex ++){
                if (charsToCompartment.containsKey(compartmentTwo.charAt(itemIndex))){
                    charsToCompartment.put(compartmentTwo.charAt(itemIndex), 2);
                }
            }
            charsToCompartment.forEach((character, compartment) -> {
                if (compartment == 2){
                    int value = Character.isLowerCase(character) ? ((int) character) - 96 : ((int) character) - 38;
                    System.out.println("Character: " + character + ", Priority: "+ value);
                    totalPriorities.addAndGet(value);
                    System.out.println("Current sum of priorities: "+ totalPriorities);
                }
            });
        }
         */

    // PART TWO
    /* // OLD APPROACH
        List<String> rucksacks = Main.readInput("C:/Users/dzifa/IdeaProjects/AdventOfCode2022/src/com/company/day_three/items.txt");
        AtomicInteger totalPriorities = new AtomicInteger();
        Map<Character, Integer> charsToElfGroup = new HashMap<>();
        Map<Character, Integer> count= new HashMap<>();
        for (int index = 0; index < rucksacks.size(); index++) {
            System.out.println("Rucksack "+ index);
            String items = rucksacks.get(index);
            for (int itemIndex =0; itemIndex < items.length(); itemIndex ++){
                if (charsToElfGroup.containsKey(items.charAt(itemIndex))){
                    if (charsToElfGroup.get(items.charAt(itemIndex)) != index % 3 ){
                        count.put(items.charAt(itemIndex), count.getOrDefault(items.charAt(itemIndex), 1) + 1);
                        System.out.println("added: " + items.charAt(itemIndex) + ", " + count.get(items.charAt(itemIndex)));
                    }
                }
                charsToElfGroup.put(items.charAt(itemIndex), index % 3);
            }
            if ((index+1) % 3 == 0){
                count.forEach((character, noOfOccurrences) -> {
                    if (noOfOccurrences == 3){
                        int value = Character.isLowerCase(character) ? ((int) character) - 96 : ((int) character) - 38;
                        System.out.println("Character: " + character + ", Priority: "+ value);
                        totalPriorities.addAndGet(value);
                        System.out.println("Current sum of priorities: "+ totalPriorities);
                    }
                });
                charsToElfGroup.clear();
                count.clear();
            }

        }

         */

}
