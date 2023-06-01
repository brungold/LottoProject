package pl.lotto.generatenumbers;

import java.util.Set;

/**
 * The GenerateNumbers interface defines the contract for classes that generate winning numbers in the lotto game.
 * It declares a method to generate a set of winning numbers.
 */
public interface GenerateNumbers {
    Set<Integer> generateWiningNumbers();
}
