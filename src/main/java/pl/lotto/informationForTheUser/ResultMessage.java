package pl.lotto.informationForTheUser;


import lombok.Data;

import java.util.Set;
/**

 The ResultMessage class represents a message containing the result of a lotto game and provides methods
 for generating the appropriate message based on the result and converting sets of numbers to formatted strings.
 */

import static pl.lotto.informationForTheUser.Messages.*;

@Data
public class ResultMessage {
    private final int result;
    private final Set<Integer> userNumbersSet;
    private final Set<Integer> winningNumbers;


    public String getMessage() {
        return switch (result) {
            case 6 -> String.format(WINNING_MESSAGE, result, setToString(winningNumbers), setToString(userNumbersSet));
            case 5, 4 ->
                    String.format(HIT_FOUR_OR_FIVE, result, setToString(winningNumbers), setToString(userNumbersSet));
            default ->
                    String.format(LESS_HITS_THAN_FOUR, result, setToString(winningNumbers), setToString(userNumbersSet));
        };
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
