package pl.lotto.generatenumbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ResultNumbersValidableTest {
    @Test
    public void should_validate_numbers_player_hit_four_numbers() {
        //given
        Set<Integer> playerNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> winingNumbers = new HashSet<>(Arrays.asList(1, 3, 5, 6, 9, 10));

        NumbersValidable numbersValidable = new ResultNumbersValidable();

        //when
        int hits = numbersValidable.validateNumbers(playerNumbers, winingNumbers);

        //then
        assertEquals(4, hits);
    }

    @Test
    public void should_validate_numbers_player_hit_zero() {
        //given
        Set<Integer> playerNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> winingNumbers = new HashSet<>(Arrays.asList(11, 13, 25, 36, 49, 71));

        NumbersValidable numbersValidable = new ResultNumbersValidable();

        //when
        int hits = numbersValidable.validateNumbers(playerNumbers, winingNumbers);

        //then
        assertEquals(0, hits);
    }

    @Test
    public void should_validate_numbers_player_hit_six_numbers() {
        //given
        Set<Integer> playerNumbers = new HashSet<>(Arrays.asList(11, 13, 25, 36, 49, 71));
        Set<Integer> winingNumbers = new HashSet<>(Arrays.asList(11, 13, 25, 36, 49, 71));

        NumbersValidable numbersValidable = new ResultNumbersValidable();

        //when
        int hits = numbersValidable.validateNumbers(playerNumbers, winingNumbers);

        //then
        assertEquals(6, hits);
    }
}