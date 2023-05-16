package pl.lotto.informationForTheUser;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultMessageTest {

    @Test
    public void test_winning_message() {
        // Given
        int result = 6;
        Set<Integer> userNumbersSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ResultMessage resultMessage = new ResultMessage(result, userNumbersSet, winningNumbers);

        // When
        String message = resultMessage.getMessage(result, userNumbersSet, winningNumbers);

        // Then
        String expectedMessage = "Congratulations you hit 6 digits! Splendidly! You won the grand prize! \n" +
                "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 5, 6]";
        assertEquals(expectedMessage, message);
    }

    @Test
    public void test_hit_four_or_five_message() {
        // Given
        int result = 4;
        Set<Integer> userNumbersSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 15, 16));
        ResultMessage resultMessage = new ResultMessage(result, userNumbersSet, winningNumbers);

        // When
        String message = resultMessage.getMessage(result, userNumbersSet, winningNumbers);

        // Then
        String expectedMessage = "You hit 4 digits! Congratulations!\n" +
                "Winning numbers were: [1, 2, 3, 4, 15, 16] and yours were: [1, 2, 3, 4, 5, 6]";
        assertEquals(expectedMessage, message);
    }

    @Test
    public void test_less_hits_than_four_message() {
        // Given
        int result = 1;
        Set<Integer> userNumbersSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 12, 23, 34, 55, 46));
        ResultMessage resultMessage = new ResultMessage(result, userNumbersSet, winningNumbers);

        // When
        String message = resultMessage.getMessage(result, userNumbersSet, winningNumbers);

        // Then
        String expectedMessage = "You hit 1 , unfortunately not this time...\n" +
                "Winning numbers were: [1, 12, 23, 34, 55, 46] and yours were: [1, 2, 3, 4, 5, 6]";
        assertEquals(expectedMessage, message);
    }
}