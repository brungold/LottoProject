package pl.lotto.inputSetting;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import pl.lotto.dataSetting.NumbersSetting;
import pl.lotto.informationForTheUser.Messages;

/**
 * The UserNumbersSet class collects numbers entered by the user in a simulated game of lotto.
 * It provides validation for the input data and checks the correctness of the number range.
 */
public class UserNumbersSet implements UserNumbers {

    public Set<Integer> collectUserNumbers(Scanner scanner) {
        Set<Integer> userNumbers = new HashSet<>();
        int remainingNumbers = NumbersSetting.NUMBER_OF_NUMBERS - userNumbers.size();
        System.out.printf((Messages.GAME_RULES) + "%n", remainingNumbers, NumbersSetting.BOTTOM_LIMIT, NumbersSetting.TOP_LIMIT);

        while (!getFullSet(userNumbers)) {
            String input = scanner.next();
            if (input.trim().isEmpty()) {
                System.out.println(Messages.GIVE_NUMBER);
            } else if (isNumber(input) && isInRange(Integer.parseInt(input))) {
                int number = Integer.parseInt(input);
                if (userNumbers.contains(number)) {
                    System.out.printf((Messages.REPEATED_NUMBER) + "%n", number);
                } else {
                    userNumbers.add(number);
                    remainingNumbers = NumbersSetting.NUMBER_OF_NUMBERS - userNumbers.size();
                    System.out.println((String.format(Messages.REMAINING_NUMBERS, number, remainingNumbers)));
                }
            } else {
                System.out.println(Messages.WRONG_NUMBER);
            }
        }
        scanner.close();
        return userNumbers;
    }

    private boolean getFullSet(Set<Integer> userNumbers) {
        return userNumbers.size() == NumbersSetting.NUMBER_OF_NUMBERS;
    }


    private boolean isInRange(int number) {
        return (number >= NumbersSetting.BOTTOM_LIMIT) && (number <= NumbersSetting.TOP_LIMIT);
    }


    private boolean isNumber(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}