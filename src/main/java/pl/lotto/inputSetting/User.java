package pl.lotto.inputSetting;

import pl.lotto.dataSetting.NumbersSetting;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User implements UserNumbers {
    private final Set<Integer> selectedNumbers = new HashSet<>();

    protected void addNumber(int number) {
        selectedNumbers.add(number);
    }

    protected boolean getFullSet() {
        return selectedNumbers.size() == NumbersSetting.NUMBER_OF_NUMBERS;
    }

    public Set<Integer> getUserNumbers() {
        return Collections.unmodifiableSet(selectedNumbers);

    }
}
