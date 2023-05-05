package pl.lotto.informationForTheUser;

import pl.lotto.inputSetting.UserNumbersSet;


import java.util.Set;

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
                return "Congratulations you hit " + result + " digits! Splendidly! You won the grand prize! \n" +
                        "Winning numbers were " + setToString(getWinningNumbers()) + " and yours were " + setToString(getUserNumbersSet());

            case 5:
            case 4:
                return "You hit " + result + " digits! Congratulations!\n" +
                        "Winning numbers were " + setToString(getWinningNumbers()) + " and yours were " + setToString(getUserNumbersSet());

            default:
                return "You hit " + result + " , unfortunately not this time...\n" +
                        "Winning numbers were " + setToString(getWinningNumbers()) + " and yours were " + setToString(getUserNumbersSet());
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
