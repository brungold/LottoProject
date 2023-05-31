package pl.lotto.generateNumbers;

import java.security.SecureRandom;
import java.util.Set;
import java.util.stream.Collectors;

import pl.lotto.dataSetting.NumbersSetting;

/**
 * The WiningNumbersGenerator class implements the GenerateNumbers interface and provides a method to generate winning numbers for the lotto game.
 * It uses a SecureRandom instance to generate a set of random integers within the specified number range and returns the set of winning numbers.
 */
public class WiningNumbersGenerator implements GenerateNumbers {

    @Override
    public Set<Integer> generateWiningNumbers() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.ints(NumbersSetting.NUMBER_OF_NUMBERS,
                        NumbersSetting.BOTTOM_LIMIT,
                        NumbersSetting.TOP_LIMIT)
                .boxed()
                .collect(Collectors.toSet());
    }
}
