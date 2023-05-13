package pl.lotto.informationForTheUser;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ResultMessageTest {
    @Test
    public void test_get_message_six_hits() {
        //given
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

        //when
        ResultMessage resultMessage = new ResultMessage(6, userNumbersSet, winningNumbers);
        String expectedMessage = "Congratulations you hit 6 digits! Splendidly! You won the grand prize! \n" +
                "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 5, 6]";
        String actualMessage = resultMessage.getMessage(6, userNumbersSet, winningNumbers);

        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_get_message_five_or_four_hits() {
        //given
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
        winningNumbers.add(7);

        //when
        ResultMessage resultMessage = new ResultMessage(5, winningNumbers, userNumbersSet);
        String expectedMessage = "You hit 5 digits! Congratulations!\n" +
                "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 5, 7]";
        String actualMessage = resultMessage.getMessage(5, winningNumbers, userNumbersSet);

        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_get_message_for_five_to_zero_hits() {
        //given
        Set<Integer> userNumbersSet = new HashSet<>();
        userNumbersSet.add(1);
        userNumbersSet.add(2);
        userNumbersSet.add(5);
        userNumbersSet.add(6);
        userNumbersSet.add(7);
        userNumbersSet.add(8);

        Set<Integer> winningNumbers = new HashSet<>();
        winningNumbers.add(1);
        winningNumbers.add(45);
        winningNumbers.add(56);
        winningNumbers.add(76);
        winningNumbers.add(77);
        winningNumbers.add(92);

        //when
        ResultMessage resultMessage = new ResultMessage(1, winningNumbers, userNumbersSet);
        String expectedMessage = "You hit 1 , unfortunately not this time...\n" +
                "Winning numbers were: [1, 2, 5, 6, 7, 8] and yours were: [1, 56, 76, 92, 45, 77]";
        String actualMessage = resultMessage.getMessage(1, winningNumbers, userNumbersSet);

        //then
        assertEquals(expectedMessage, actualMessage);
    }
}