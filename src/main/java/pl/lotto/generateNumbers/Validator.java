package pl.lotto.generateNumbers;

import pl.lotto.informationForTheUser.ResultMessage;

import java.util.Set;

public interface Validator {
    int validateNumbers(Set<Integer> set1, Set<Integer> set2);
}
