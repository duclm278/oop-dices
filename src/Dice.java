public class Dice {
    private int sideCount;        // 6
    private double[] sideWeights; // [20, 16, 16, 16, 16, 16]
    private double[] weightedSum; // [20, 36, 52, 68, 84, 100]

    public Dice() {
        this(1, 1, 1, 1, 1, 1 );
    }

    public Dice(double... sideWeights) {
        this.sideCount = sideWeights.length;
        this.sideWeights = sideWeights;
        setWeightedSum();
    }

    public void setWeightedSum() {
        weightedSum = new double[sideCount];

        weightedSum[0] = sideWeights[0];
        for (int i = 1; i < sideCount; i++) {
            weightedSum[i] = weightedSum[i - 1] + sideWeights[i];
        }
    }

    public int roll() {
        double min = 0;
        double max = weightedSum[sideCount - 1];
        double random = min + Math.random() * (max - min);
        for (int i = 0; i < sideCount - 1; i++) {
            if (random < weightedSum[i])
                return i + 1;
        }

        return sideCount;
    }

    public double[] getSideWeights() {
        return sideWeights;
    }

    public double[] getWeightedSum() {
        return weightedSum;
    }
}
