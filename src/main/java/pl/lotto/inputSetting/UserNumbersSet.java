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

    public Set<Integer> getUserNumbers() {
        return Collections.unmodifiableSet(userNumbers);
    }

    public Set<Integer> collectNumbers() {

        while (userNumbers.size() < NumbersSetting.NUMBER_OF_NUMBERS) {
            String input = inputDataFromUser.inputFromUser();
            if (input.trim().isEmpty()) {
                System.out.println("Please enter a number.");
                int remainingNumbers = NumbersSetting.NUMBER_OF_NUMBERS - userNumbers.size();
                System.out.println("Enter " + remainingNumbers + " more numbers from 1 to 99. Press the ENTER button after each digit.");
                if (verifyNumbers.isNumber(input) && numberRange.isInRange(Integer.parseInt(input))) {
                    userNumbers.add(Integer.parseInt(input));
                    System.out.println("Number " + input + " added. " + remainingNumbers + " more numbers needed.");
                } else {
                    System.out.println("Upsss, please check if this is the correct value.");
                }
            }

        }
        return userNumbers;
    }
}
