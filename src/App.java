import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Dice> dices = new ArrayList<>();
        dices.add(new Dice(20, 16, 16, 16, 16, 16 ));
        dices.add(new Dice(16, 20, 16, 16, 16, 16 ));
        dices.add(new Dice(16, 16, 20, 16, 16, 16 ));
        dices.add(new Dice(16, 16, 16, 20, 16, 16 ));

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Duc", false));
        players.add(new Player("Huy", true, "Again!"));
        players.add(new Player("Phu", true, "Lucky!"));
        players.add(new Player("Duy", true, "Impossible!"));

        // Set startingPlayer randomly
        int startingPlayer = (int) (Math.random() * 4) + 1; // 1-based indexing
        Judge judge = new Judge(4, startingPlayer, 21);

        int currentDice = 0;
        int rolledScore = 0;
        int playerIndex = 0;
        int beforeScore = 0;
        Player currentPlayer = null;

        while (true) {
            // Get player
            playerIndex = judge.nextPlayer() - 1;
            currentPlayer = players.get(playerIndex);
            beforeScore = currentPlayer.getScore();
            System.out.println("It's your turn: " + currentPlayer.getName());
            System.out.println("Your score: " + currentPlayer.getScore());

            // Get random dice
            currentDice = (int) (Math.random() * 4);
            // System.out.println(currentPlayer.getName() + ": gets dice " + (currentDice + 1));

            // Roll dice
            rolledScore = dices.get(currentDice).roll();
            if (currentPlayer.isAutoPlay() == false) {
                String choice = null;
                while(true) {
                    System.out.print("Keep shaking? (y/N): ");
                    choice = sc.nextLine();
                    if (choice.equals("y"))
                        rolledScore = dices.get(currentDice).roll();
                    else
                        break;
                }
            }

            // Update score
            judge.updateScore(currentPlayer, rolledScore);

            // Print results
            System.out.println(
                currentPlayer.getName() +
                ": before = " + String.format("%02d", beforeScore) +
                ", rolled = " + String.format("%02d", rolledScore) +
                ", after = " + String.format("%02d", currentPlayer.getScore())
            );
            System.out.println();

            // Stop if found winner
            if (currentPlayer.getScore() == 21) {
                judge.endGame(playerIndex, players);
                return;
            }
        }
    }
}
