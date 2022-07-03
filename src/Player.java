public class Player {
    private String name;
    private boolean autoPlay;
    private int score;
    private String lostSpeech;

    public Player(String name, boolean autoPlay) {
        this(name, autoPlay, "I lose!");
    }

    public Player(String name, boolean autoPlay, String lostSpeech) {
        this.name = name;
        this.autoPlay = autoPlay;
        this.score = 0;
        this.lostSpeech = lostSpeech;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLostSpeech() {
        return lostSpeech;
    }

    public void setLostSpeech(String lostSpeech) {
        this.lostSpeech = lostSpeech;
    }
}
