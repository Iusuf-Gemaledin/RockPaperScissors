// Back-end

package Projects.RockPaperScissors;

import java.util.Random;

public class RockPaperScissors {
    private static final String [] computerChoices = {"Rock", "Paper", "Scissors"};
    
    public String getComputerChoice () {
        return computerChoice;
    }

    public int getComputerScore () {
        return computerScore;
    }

    public int getPlayerScore () {
        return playerScore;
    }

    //stores the Computer's choice
    private String computerChoice;

    //stores the scores
    private int computerScore, playerScore;
    
    //generates a random choice for the Computer
    private Random random;

    //constructor - initializes random obejcts
    public RockPaperScissors () {
        random = new Random ();
    }

    //returns the result of the game (win, lose or draw)
    public String playRockPaperScissors (String playerChoice) {
        //generates the Computer's choice
        computerChoice = computerChoices [random.nextInt (computerChoices.length)];

        //returns the result of the match
        String result;

        //evaluates the winner
        if (computerChoice.equals ("Rock")) {
            if (playerChoice.equals ("Paper")) {
                result = "Congrats! You Won!";
                playerScore++;
            }else if (playerChoice.equals ("Scissors")) {
                result = "You Lost!";
                computerScore++;
            }else {
                result = "It's a draw!";
            }
        }else if (computerChoice.equals ("Paper")) {
            if (playerChoice.equals ("Scissors")) {
                result = "Congrats! You Won!";
                playerScore++;
            }else if (playerChoice.equals ("Rock")) {
                result = "You Lost!";
                computerScore++;
            }else {
                result = "It's a draw!";
            }
        }else {
            if (playerChoice.equals ("Rock")) {
                result = "Congrats! You Won!";
                playerScore++;
            }else if (playerChoice.equals ("Paper")) {
                result = "You Lost!";
                computerScore++;
            }else {
                result = "It's a draw!";
            }
        }

        return result;
    }
}
