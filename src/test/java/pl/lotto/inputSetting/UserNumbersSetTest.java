package pl.lotto.inputSetting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserNumbersSetTest implements SampleScanner {

    @Test
    public void testCollectNumbers() {
        // given
        String inputData = "1\n2\n3\n4\n5\n6\n";
        UserNumbersSet userNumbersSet = createUserNumbersSet(inputData);

        // when
        Set<Integer> selectedNumbers = userNumbersSet.collectNumbers();

        // then
        assertEquals(6, selectedNumbers.size());
        assertTrue(selectedNumbers.contains(1));
        assertTrue(selectedNumbers.contains(2));
        assertTrue(selectedNumbers.contains(3));
        assertTrue(selectedNumbers.contains(4));
        assertTrue(selectedNumbers.contains(5));
        assertTrue(selectedNumbers.contains(6));
    }

    @Test
    public void collect_numbers_returns_correct_set_of_numbers_when_user_inputs_valid_data() {
        //given
        String inputData = "10\n24\n15\n23\n18\n99\n";
        UserNumbersSet userNumbersSet = createUserNumbersSet(inputData);

        //when
        Set<Integer> selectedNumbers = userNumbersSet.collectNumbers();

        //then
        Set<Integer> expectedNumbers = new HashSet<>(Arrays.asList(99, 18, 23, 15, 24, 10));
        assertEquals(expectedNumbers, selectedNumbers);
    }

    @Test
    public void collect_numbers_returns_error_when_user_inputs_less_than_6_numbers() {
        //given
        //when
        //then
    }

    @Test
    public void collect_numbers_returns_error_when_user_inputs_more_than_6_numbers() {
        //given
        //when
        //then
    }

    @Test
    public void collect_numbers_returns_error_when_user_inputs_number_outside_1_to_99_range() {
        //given
        //when
        //then
    }

    @Test
    public void collect_numbers_returns_error_when_user_inputs_duplicate_number() {
        //given
        //when
        //then
    }

    @Test
    public void collect_numbers_returns_correct_set_of_numbers_when_user_inputs_both_valid_and_invalid_data() {
        //given
        //when
        //then
    }
}