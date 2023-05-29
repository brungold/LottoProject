package pl.lotto.generateNumbers;

import pl.lotto.informationForTheUser.ResultMessage;

import java.util.HashSet;
import java.util.Set;

public class ResultValidator implements Validator {
    @Override
    public ResultMessage validateNumbers(Set<Integer> userNumbers, Set<Integer> winningNumbers) {
        Set<Integer> commonElements = new HashSet<>(userNumbers);
        commonElements.retainAll(winningNumbers);
        int result = commonElements.size();
        return new ResultMessage(result, userNumbers, winningNumbers);
    }
}
