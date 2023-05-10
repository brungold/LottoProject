package pl.lotto.inputSetting;

import java.util.Set;

import pl.lotto.dataSetting.NumbersSetting;
import pl.lotto.informationForTheUser.Messages;

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
        System.out.println(String.format(Messages.GAME_RULES, remainingNumbers, NumbersSetting.BOTTOM_LIMIT, NumbersSetting.TOP_LIMIT));

        while (!user.getFullSet()) {
            String input = inputDataFromUser.inputFromUser();
            if (input.trim().isEmpty()) {
                System.out.println(Messages.GIVE_NUMBER);
            } else if (verifyNumbers.isNumber(input) && numberRange.isInRange(Integer.parseInt(input))) {
                int number = Integer.parseInt(input);
                if (user.getUserNumbers().contains(number)) {
                    System.out.println(String.format(Messages.REPEATED_NUMBER, number));
                } else {
                    user.addNumber(number);
                    remainingNumbers = NumbersSetting.NUMBER_OF_NUMBERS - user.getUserNumbers().size();
                    System.out.println((String.format(Messages.REMAINING_NUMBERS, number,remainingNumbers)));
                }
            } else {
                System.out.println(Messages.WRONG_NUMBER);
            }
        }
        return user.getUserNumbers();
    }
}
