package pl.lotto.generateNumbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ResultValidatorTest {
    @Test
    public void test_validate_numbers_player_hit_four_numbers() {
        //given
        Set<Integer> playerNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> winingNumbers = new HashSet<>(Arrays.asList(1, 3, 5, 6, 9, 10));

        Validator validator = new ResultValidator();

        //when
        int hits = validator.validateNumbers(playerNumbers, winingNumbers);

        //then
        assertEquals(4, hits);
    }
}