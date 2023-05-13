package pl.lotto.informationForTheUser;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ResultMessageTest {
    @Test
    public void test_get_message_six_hits() {
        Set<Integer> userNumbersSet = new HashSet<>();
        userNumbersSet.add(1);
        userNumbersSet.add(2);
        userNumbersSet.add(3);
        userNumbersSet.add(4);
        userNumbersSet.add(5);
        userNumbersSet.add(6);

        Set<Integer> winningNumbers = new HashSet<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        ResultMessage resultMessage = new ResultMessage(6, userNumbersSet, winningNumbers);
        String expectedMessage = "Congratulations you hit 6 digits! Splendidly! You won the grand prize! \n" +
                "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 5, 6]";
        String actualMessage = resultMessage.getMessage(6, userNumbersSet, winningNumbers);

        assertEquals(expectedMessage, actualMessage);
    }
}