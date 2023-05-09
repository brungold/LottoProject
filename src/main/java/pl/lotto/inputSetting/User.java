package pl.lotto.inputSetting;

import pl.lotto.dataSetting.NumbersSetting;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User implements UserNumbers{
    private final Set<Integer> selectedNumbers = new HashSet<>();

    public void addNumber(int number) {
        selectedNumbers.add(number);
    }

    public Set<Integer> getUserNumbers() {
        return Collections.unmodifiableSet(selectedNumbers);

    }
    private boolean getFullSet () {
        return selectedNumbers.size() == NumbersSetting.NUMBER_OF_NUMBERS;
    }
}
