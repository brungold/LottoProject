package pl.lotto.informationForTheUser;


import lombok.Data;

import java.util.Set;

import static pl.lotto.informationForTheUser.Messages.*;

@Data
public class ResultMessage implements Result{
    private final int result;
    private final Set<Integer> userNumbersSet;
    private final Set<Integer> winningNumbers;


    public String getMessage() {
        switch (result) {
            case 6:
                return String.format(WINNING_MESSAGE, result, setToString(winningNumbers), setToString(userNumbersSet));

            case 5:
            case 4:
                return String.format(HIT_FOUR_OR_FIVE, result, setToString(winningNumbers), setToString(userNumbersSet));

            default:
                return String.format(LESS_HITS_THAN_FOUR, result, setToString(winningNumbers), setToString(userNumbersSet));
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
