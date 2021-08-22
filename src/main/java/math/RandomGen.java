package math;

import java.util.Objects;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author Weiyan Xiang on 2020/10/8
 */
public class RandomGen {

    private int[] randomNums;
    private float[] probabilities;
    private Random random;
    private TreeMap<Float, Integer> weightedMap;

    public RandomGen(int[] randomNums, float[] probabilities) {
        this(randomNums, probabilities, new Random());
    }

    protected RandomGen(int[] randomNums, float[] probabilities, Random random) {
        validateInputs(randomNums, probabilities);

        this.randomNums = randomNums;
        this.probabilities = probabilities;
        this.weightedMap = new TreeMap<>();
        this.random = random;

        float sum = Float.MIN_VALUE;
        for (float p : probabilities) sum += p;
        float scale = 1 / sum;

        float weight = 0f;
        for (int i = 0; i < randomNums.length; i++) {
            weight += this.probabilities[i];
            this.weightedMap.put(scale * weight, this.randomNums[i]);
        }
    }

    private void validateInputs(int[] randomNums, float[] probabilities) {
        Objects.requireNonNull(randomNums, ("randomNums should not be null"));
        Objects.requireNonNull(probabilities, ("probabilities should not be null"));
        if (randomNums.length != probabilities.length)
            throw new IllegalArgumentException("Length of randomNums and probabilities are not equal.");
    }

    /**
     * @return one of the randomNums. When this method is called multiple times over a long period, it should return the
     * numbers roughly with the initialized probabilities.
     */
    public int nextNum() {
        return weightedMap.ceilingEntry(random.nextFloat()).getValue();
    }
}
