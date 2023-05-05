package pl.lotto.inputSetting;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import pl.lotto.dataSetting.NumbersSetting;

public class UserNumbersSet implements UserNumbers {
    private final Set<Integer> userNumbers = new HashSet<>();
    private final InputDataFromUser inputDataFromUser;
    private final NumberRange numberRange;
    private final VerifyNumbers verifyNumbers;



    public UserNumbersSet(InputDataFromUser inputDataFromUser, NumberRange numberRange, VerifyNumbers verifyNumbers) {
        this.inputDataFromUser = inputDataFromUser;
        this.numberRange = numberRange;
        this.verifyNumbers = verifyNumbers;
    }

    public Set<Integer> getUserNumbers () {
        return Collections.unmodifiableSet(userNumbers);
    }
    public Set<Integer> collectNumbers() {
        while (userNumbers.size() < NumbersSetting.NUMBER_OF_NUMBERS) {
            String input = inputDataFromUser.inputFromUser();
            if (verifyNumbers.isNumber(input) && numberRange.isInRange(Integer.parseInt(input))) {
                userNumbers.add(Integer.parseInt(input));
            } else {
                System.out.println("Upsss, please check if this is the correct value.");
            }
        }
        return userNumbers;
    }
}
