package pl.lotto.generateNumbers;

import pl.lotto.informationForTheUser.ResultMessage;

import java.util.HashSet;
import java.util.Set;

public class ResultValidator implements Validator {
    @Override
    public int validateNumbers(Set<Integer> userNumbers, Set<Integer> winningNumbers) {
        Set<Integer> commonElements = new HashSet<>(userNumbers);
        commonElements.retainAll(winningNumbers);
        return commonElements.size();
    }
}
