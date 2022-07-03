import java.util.ArrayList;

public class Judge {
    private int turnCount;      // 1-based indexing
    private int playerCount;
    private int startingPlayer; // 1-based indexing
    private int winningScore;

    public Judge(int playerCount, int startingPlayer, int winningScore) {
        this.turnCount = 0;
        this.playerCount = playerCount;
        this.startingPlayer = startingPlayer;
        this.winningScore = winningScore;
    }

    public int nextPlayer() {
        turnCount++;
        return (startingPlayer + turnCount - 2) % playerCount + 1;
    }

    public void updateScore(Player player, int rolledScore) {
        int currentScore = player.getScore();
        if (currentScore + rolledScore > winningScore) {
            player.setScore(0);
        } else {
            player.setScore(currentScore + rolledScore);
        }
    }

    public void endGame(int playerIndex, ArrayList<Player> players) {
        System.out.println(players.get(playerIndex).getName() + " wins!");

        Player player = null;
        for (int i = 0; i < players.size(); i++) {
            player = players.get(i);
            if (i != playerIndex && player.isAutoPlay())
                System.out.println(player.getName() + " says: " + player.getLostSpeech());
        }
    }

    public void newGame(int playerCount, int startingPlayer) {
        this.turnCount = 0;
        this.playerCount = playerCount;
        this.startingPlayer = startingPlayer;
    }
}
