import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public RockPaperScissors(){
        Scanner scanner = new Scanner(System.in);
        String[] rps = {"rock", "paper", "scissors"};
        int botScore = 0;
        int playerScore = 0;
        String playerMove = "";
        String botMove = "";
        System.out.println("First To Three");
        System.out.println("-------------------------");
        List<String> totalPlayerMoves = new ArrayList<>();
        while(botScore < 3 && playerScore < 3){
            boolean x = false;
            boolean roundWinner;
            while(!x) {
                System.out.println("Your move: rock, paper or scissors");
                playerMove = scanner.nextLine();
                for(String i : rps){
                    if(playerMove.contains(i)){
                        x = true;
                    }
                }
            }
            botMove = botCalculator(totalPlayerMoves, rps);
            totalPlayerMoves.add(playerMove);
            System.out.println("bot went " + botMove);
            roundWinner = winConditions(playerMove, botMove);
            if(botMove.equals(playerMove)) System.out.println("tie");
            else if(roundWinner){
                System.out.println("Player won this round");
                playerScore++;
            }
            else{
                System.out.println("Player Lost this round");
                botScore++;
            }
            System.out.println("-------------------------");
            System.out.println("Player Score " + playerScore);
            System.out.println("Bot Score " + botScore);
            System.out.println("-------------------------");
        }
        if(botScore > playerScore){
            System.out.println("Bot won");
        }else {
            System.out.println("Player won");
        }
    }
    public boolean winConditions(String playerInput, String botInput){
        return playerInput.equals("rock") && botInput.equals("scissors") ||
                playerInput.equals("scissors") && botInput.equals("paper") ||
                playerInput.equals("paper") && botInput.equals("rock");
    }
    public String botCalculator(List<String> totalPlayerMoves, String[] rps){
        int rock = 0;
        int scissors = 0;
        int paper = 0;
        if((int)((Math.random() * 2)+1) == 1){
            for (int i = 0; i < totalPlayerMoves.size(); i++) {
                if (totalPlayerMoves.get(i).equals("rock")) rock++;
                else if (totalPlayerMoves.get(i).equals("scissors")) scissors++;
                else if (totalPlayerMoves.get(i).equals("paper")) paper++;
            }
            if (rock > scissors) return "paper";
            else if (scissors > paper) return "rock";
            else if(paper > scissors) return "paper";
        }
        return rps[((int)(Math.random() * 2))];
    }

}
