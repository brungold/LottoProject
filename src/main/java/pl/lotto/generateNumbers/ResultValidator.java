package pl.lotto.generateNumbers;


import java.util.HashSet;
import java.util.Set;

/**
 * The ResultValidator class implements the Validator interface and provides a method to validate user numbers
 * against winning numbers in the lotto game.It determines the number of common elements between
 * the user numbers and winning numbers, and returns the result as an integer.
 */
public class ResultValidator implements Validator {
    @Override
    public int validateNumbers(Set<Integer> userNumbers, Set<Integer> winningNumbers) {
        Set<Integer> commonElements = new HashSet<>(userNumbers);
        commonElements.retainAll(winningNumbers);
        return commonElements.size();
    }
}
