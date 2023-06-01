package pl.lotto.informationForTheUser;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultMessageTest {

    @Test
    public void should_return_winning_message() {
        // given
        int result = 6;
        Set<Integer> userNumbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        ResultMessage resultMessage = new ResultMessage(result, userNumbers, winningNumbers);

        // when
        String message = resultMessage.getMessage();

        // then
        String expectedMessage = "Congratulations you hit 6 digits! Splendidly! You won the grand prize! \n" +
                "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 5, 6]";
        assertEquals(expectedMessage, message);
    }

    @Test
    public void should_return_message_for_hit_four_or_five() {
        // given
        int result = 4;
        Set<Integer> userNumbers = new TreeSet<>(Set.of(1, 2, 3, 4, 10, 23));
        Set<Integer> winningNumbers = new TreeSet<>(Set.of(1, 2, 3, 4, 5, 6));
        ResultMessage resultMessage = new ResultMessage(result, userNumbers, winningNumbers);

        // when
        String message = resultMessage.getMessage();

        // then
        String expectedMessage = "You hit 4 digits! Congratulations!\n" +
                "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 10, 23]";
        assertEquals(expectedMessage, message);
    }

    @Test
    void should_return_message_for_less_than_four_hits() {
        // given
        int result = 2;
        Set<Integer> userNumbers = new TreeSet<>(Set.of(1, 2, 10, 23, 14, 92));
        Set<Integer> winningNumbers = new TreeSet<>(Set.of(1, 2, 3, 4, 5, 6));
        ResultMessage resultMessage = new ResultMessage(result, userNumbers, winningNumbers);

        // when
        String message = resultMessage.getMessage();

        // then
        String expectedMessage = "You hit 2 , unfortunately not this time...\n" +
                "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 10, 14, 23, 92]";
        assertEquals(expectedMessage, message);
    }
}