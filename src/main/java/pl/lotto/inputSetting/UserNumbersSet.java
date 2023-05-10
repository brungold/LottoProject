package pl.lotto.inputSetting;

import java.util.Set;

import pl.lotto.dataSetting.NumbersSetting;
import pl.lotto.informationForTheUser.Messeges;

public class UserNumbersSet {
    private final InputData inputDataFromUser;
    private final NumberRange numberRange;
    private final VerifyNumbers verifyNumbers;
    private final User user;


    public UserNumbersSet(InputData inputDataFromUser, NumberRange numberRange, VerifyNumbers verifyNumbers, User user) {
        this.inputDataFromUser = inputDataFromUser;
        this.numberRange = numberRange;
        this.verifyNumbers = verifyNumbers;
        this.user = user;
    }


    public Set<Integer> collectNumbers() {
        int remainingNumbers = NumbersSetting.NUMBER_OF_NUMBERS - user.getUserNumbers().size();
        System.out.println(String.format(Messeges.REMAINING_NUMBERS, remainingNumbers, NumbersSetting.BOTTOM_LIMIT, NumbersSetting.TOP_LIMIT));

        while (!user.getFullSet()) {
            String input = inputDataFromUser.inputFromUser();
            if (input.trim().isEmpty()) {
                System.out.println("Please enter a number.");
            } else if (verifyNumbers.isNumber(input) && numberRange.isInRange(Integer.parseInt(input))) {
                int number = Integer.parseInt(input);
                if (user.getUserNumbers().contains(number)) {
                    System.out.println("You have already entered number " + number + ".");
                } else {
                    user.addNumber(number);
                    remainingNumbers = NumbersSetting.NUMBER_OF_NUMBERS - user.getUserNumbers().size();
                    System.out.println("Number " + number + " added. " + remainingNumbers + " more numbers needed.");
                }
            } else {
                System.out.println(Messeges.WRONG_NUMBER);
            }
        }
        return user.getUserNumbers();
    }
}
