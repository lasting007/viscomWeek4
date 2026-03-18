package com.codedotorg;

import java.util.Random;

public class GameLogic {

    /** Whether or not the game is over */
    private boolean gameOver;

    public GameLogic() {
        gameOver = false;
    }

    public String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random rand = new Random();
        return choices[rand.nextInt(3)];
    }

    public String determineWinner(String predictedClass, String computerChoice) {
        predictedClass = predictedClass.toLowerCase().trim();
        computerChoice = computerChoice.toLowerCase().trim();

        if (predictedClass.contains("rock")) {
            predictedClass = "rock";
        } else if (predictedClass.contains("paper")) {
            predictedClass = "paper";
        } else if (predictedClass.contains("scissors")) {
            predictedClass = "scissors";
        } else {
            gameOver = true;
            return "User: " + predictedClass + " | Computer: " + computerChoice + " → No valid gesture detected.";
        }

        if (predictedClass.equals(computerChoice)) {
            return "User: " + predictedClass + " | Computer: " + computerChoice + " → " + getTieResult();
        }

        if (
            (predictedClass.equals("rock") && computerChoice.equals("scissors")) ||
            (predictedClass.equals("paper") && computerChoice.equals("rock")) ||
            (predictedClass.equals("scissors") && computerChoice.equals("paper"))
        ) {
            return "User: " + predictedClass + " | Computer: " + computerChoice + " → " + getUserWinnerResult();
        }

        return "User: " + predictedClass + " | Computer: " + computerChoice + " → " + getComputerWinnerResult();
    }

    public String getTieResult() {
        gameOver = true;
        return "Tie!";
    }

    public String getUserWinnerResult() {
        gameOver = true;
        return "You win!";
    }

    public String getComputerWinnerResult() {
        gameOver = true;
        return "You lose :(";
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void resetLogic() {
        gameOver = false;
    }
}