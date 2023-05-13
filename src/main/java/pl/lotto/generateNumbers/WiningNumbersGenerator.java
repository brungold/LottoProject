package pl.lotto.generateNumbers;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import pl.lotto.dataSetting.NumbersSetting;

public class WiningNumbersGenerator implements GenerateNumbers {

    @Override
    public Set<Integer> generateWiningNumbers() {
        Set<Integer> winingNumbersSet = new HashSet<>();
        SecureRandom secureRandom = new SecureRandom();
        winingNumbersSet = secureRandom.ints(NumbersSetting.NUMBER_OF_NUMBERS,
                        NumbersSetting.BOTTOM_LIMIT,
                        NumbersSetting.TOP_LIMIT)
                .boxed()
                .collect(Collectors.toSet());
        return winingNumbersSet;
    }
}
