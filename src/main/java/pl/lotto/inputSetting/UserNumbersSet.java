package pl.lotto.inputSetting;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import pl.lotto.dataSetting.NumbersSetting;
import pl.lotto.informationForTheUser.Messeges;

public class UserNumbersSet {
    private final InputDataFromUser inputDataFromUser;
    private final NumberRange numberRange;
    private final VerifyNumbers verifyNumbers;


    public UserNumbersSet(InputDataFromUser inputDataFromUser, NumberRange numberRange, VerifyNumbers verifyNumbers) {
        this.inputDataFromUser = inputDataFromUser;
        this.numberRange = numberRange;
        this.verifyNumbers = verifyNumbers;
    }


    public Set<Integer> collectNumbers() {
        int remainingNumbers = NumbersSetting.NUMBER_OF_NUMBERS - userNumbers.size();
        System.out.println("Enter " + remainingNumbers + " more numbers from 1 to 99. Press the ENTER button after each digit.");

        while (!getFullSet()) {
            String input = inputDataFromUser.inputFromUser();
            if (input.trim().isEmpty()) {
                System.out.println("Please enter a number.");
            } else if (verifyNumbers.isNumber(input) && numberRange.isInRange(Integer.parseInt(input))) {
                int number = Integer.parseInt(input);
                if (userNumbers.contains(number)) {
                    System.out.println("You have already entered number " + number + ".");
                } else {
                    userNumbers.add(number);
                    remainingNumbers = NumbersSetting.NUMBER_OF_NUMBERS - userNumbers.size();
                    System.out.println("Number " + number + " added. " + remainingNumbers + " more numbers needed.");
                }
            } else {
                System.out.println(Messeges.WRONG_NUMBER);
            }
        }
        return userNumbers;
    }
}
