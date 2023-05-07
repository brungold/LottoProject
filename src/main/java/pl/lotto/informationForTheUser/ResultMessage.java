package pl.lotto.informationForTheUser;

import pl.lotto.inputSetting.UserNumbersSet;
import pl.lotto.informationForTheUser.Messeges;


import java.util.Set;

import static pl.lotto.informationForTheUser.Messeges.*;

public class ResultMessage {
    private final int result;
    private final Set<Integer> userNumbersSet;
    private final Set<Integer> winningNumbers;

    public ResultMessage(int result, Set<Integer> userNumbersSet, Set<Integer> winningNumbers) {
        this.result = result;
        this.userNumbersSet = userNumbersSet;
        this.winningNumbers = winningNumbers;
    }

    private int getResult() {
        return result;
    }

    private Set<Integer> getUserNumbersSet() {
        return userNumbersSet;
    }

    private Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public String getMessage(int result, Set<Integer> userNumbersSet, Set<Integer> winningNumber) {
        switch (result) {
            case 6:
                return String.format(WINNING_MESSAGE, result, setToString(getWinningNumbers()), setToString(getUserNumbersSet()));

            case 5:
            case 4:
                return String.format(HIT_FOUR_OR_FIVE, result, setToString(getWinningNumbers()), setToString(getUserNumbersSet()));

            default:
                return String.format(LESS_HITS_THAN_FOUR, result, setToString(getWinningNumbers()), setToString(getUserNumbersSet()));
        }
    }

    private static String setToString(Set<Integer> set) {
        StringBuilder sb = new StringBuilder("[");
        for (Integer number : set) {
            sb.append(number).append(", ");
        }
        if (!set.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
