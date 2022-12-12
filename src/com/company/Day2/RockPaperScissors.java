package com.company.Day2;

import com.company.common.InputReader;

import java.util.List;

public class RockPaperScissors {
    /* A for Rock, B for Paper, and C for Scissors
     * Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock.
     *
     */
    private static final int WIN = 6;
    private static final int DRAW = 3;
    private static final int LOSS = 0;
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;

    public static int rockPaperScissors(List<String> input){
        // read input, split by " "
        // for each line, calculate score
        //  X for Rock, Y for Paper, and Z for Scissors

        int totalScore = 0;
        for (String round : input){
            String[] play = round.split(" ");
            switch (play[0]){
                case "A":
                    if ("X".equals(play[1])){
                        totalScore += ROCK + DRAW;
                    }
                    else if ("Y".equals(play[1])){
                        totalScore += PAPER + WIN;
                    }
                    else if ("Z".equals(play[1])){
                        totalScore += SCISSORS + LOSS;
                    }
                    break;
                case "B":
                    if ("X".equals(play[1])){
                        totalScore += ROCK + LOSS;
                    }
                    else if ("Y".equals(play[1])){
                        totalScore += PAPER + DRAW;
                    }
                    else if ("Z".equals(play[1])){
                        totalScore += SCISSORS + WIN;
                    }
                    break;
                case "C":
                    if ("X".equals(play[1])){
                        totalScore += ROCK + WIN;
                    }
                    else if ("Y".equals(play[1])){
                        totalScore += PAPER + LOSS;
                    }
                    else if ("Z".equals(play[1])){
                        totalScore += SCISSORS + DRAW;
                    }
                    break;
            }
        }
        return totalScore;

    }

    public static int rockPaperScissorsPartTwo(List<String> input){
        // X means you need to lose,
        // Y means you need to end the round in a draw,
        // and Z means you need to win

        int totalScore = 0;
        for (String round : input){
            String[] play = round.split(" ");
            switch (play[0]){
                case "A":
                    if ("X".equals(play[1])){
                        totalScore += SCISSORS + LOSS;
                    }
                    else if ("Y".equals(play[1])){
                        totalScore += ROCK + DRAW;
                    }
                    else if ("Z".equals(play[1])){
                        totalScore += PAPER + WIN;
                    }
                    break;
                case "B":
                    if ("X".equals(play[1])){
                        totalScore += ROCK + LOSS;
                    }
                    else if ("Y".equals(play[1])){
                        totalScore += PAPER + DRAW;
                    }
                    else if ("Z".equals(play[1])){
                        totalScore += SCISSORS + WIN;
                    }
                    break;
                case "C":
                    if ("X".equals(play[1])){
                        totalScore += PAPER + LOSS;
                    }
                    else if ("Y".equals(play[1])){
                        totalScore += SCISSORS + DRAW;
                    }
                    else if ("Z".equals(play[1])){
                        totalScore += ROCK + WIN;
                    }
                    break;
            }
        }
        return totalScore;

    }

    public static void main(String[] args) {
        List<String> input = InputReader.read("src/com/company/Day2/strategyGuide.txt");
        System.out.println(rockPaperScissors(input));
        System.out.println(rockPaperScissorsPartTwo(input));
    }

}
