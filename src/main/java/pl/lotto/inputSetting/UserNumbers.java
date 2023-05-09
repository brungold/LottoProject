package pl.lotto.inputSetting;

import java.util.Set;

public interface UserNumbers {
    Set<Integer> getUserNumbers();

    default void addNumber(int number) {
        getUserNumbers().add(number);
    }
}

