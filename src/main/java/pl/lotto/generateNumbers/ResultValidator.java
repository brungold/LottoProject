package pl.lotto.generateNumbers;

import java.util.HashSet;
import java.util.Set;

public class ResultValidator implements Validator{
    @Override
    public int validateNumbers(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> commonElements = new HashSet<>(set1);
        commonElements.retainAll(set2);
        return commonElements.size();
    }
}
