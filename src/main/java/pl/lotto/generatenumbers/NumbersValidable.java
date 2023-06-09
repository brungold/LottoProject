package pl.lotto.generatenumbers;


import java.util.Set;

/**
 * The Validator interface defines the contract for classes that validate numbers in the lotto game.
 * It declares a method to validate two sets of numbers and returns the result as an integer.
 */
public interface NumbersValidable {
    int validateNumbers(Set<Integer> set1, Set<Integer> set2);
}
