package pl.lotto.inputSetting;

import org.junit.jupiter.api.Test;
import pl.lotto.informationForTheUser.Messages;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class UserNumbersSetTest implements SampleScanner {
    UserNumbersSet userNumbersSet = new UserNumbersSet();

    @Test
    public void test_collect_numbers() {
        // given
        Set<Integer> expectedNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1,2,3,4,5,6)));
        String inputData = "1\n2\n3\n4\n5\n6\n";
        Scanner userNumbers = createSampleScanner(inputData);

        // when
        final Set<Integer> selectedNumbers = userNumbersSet.collectUserNumbers(userNumbers);

        // then
        assertThat(expectedNumbers).isEqualTo(selectedNumbers);
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
    public void negative_test_collect_numbers_returns_error_when_user_inputs_less_than_6_numbers() {
        //given
        String inputData = "1\n2\n3\n4\n5\n";
        UserNumbersSet userNumbersSet = createUserNumbersSet(inputData);

        //when
        Set<Integer> selectedNumbers = userNumbersSet.collectNumbers();

        //then
        assertNotEquals(6, selectedNumbers.size());
    }

    @Test
    public void collect_numbers_returns_correct_set_of_numbers_when_user_inputs_both_valid_and_invalid_data() {
        //given
        String inputData = "1\n2\n3\n10\n10\n6\n100\n99\n";
        UserNumbersSet userNumbersSet = createUserNumbersSet(inputData);

        //when
        Set<Integer> selectedNumbers = userNumbersSet.collectNumbers();

        //then
        assertEquals(6, selectedNumbers.size());
    }

    /*
    Below are two tests that are expected to fail because we do not provide 6 correct digits
     */
    @Test
    public void negative_test_collect_numbers_returns_error_when_user_inputs_number_outside_1_to_99_range() {
        //given
        String inputData = "1\n2\n3\n100\n5\n6\n";
        UserNumbersSet userNumbersSet = createUserNumbersSet(inputData);

        //when
        Set<Integer> selectedNumbers = userNumbersSet.collectNumbers();

        //then
        assertNotEquals(5, selectedNumbers.size());
    }

    @Test
    public void negative_test_collect_numbers_returns_error_when_user_inputs_duplicate_number() {
        //given
        String inputData = "1\n2\n3\n10\n10\n6\n";
        UserNumbersSet userNumbersSet = createUserNumbersSet(inputData);

        //when
        Set<Integer> selectedNumbers = userNumbersSet.collectNumbers();

        //then
        assertEquals(5, selectedNumbers.size());
    }

    @Test
    void test_collect_numbers_wrong_number() {
        // given
        String inputData = "pięć\n";
        UserNumbersSet userNumbersSet = createUserNumbersSet(inputData);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // when
        userNumbersSet.collectNumbers();

        // then
        String expectedMessage = "Upsss, please check if this is the correct value.\n";
        assertEquals(expectedMessage, Messages.WRONG_NUMBER);
        assertEquals("You must enter 6 digits from 1 to 99. Press the ENTER button after each digit\npięć\nUpsss, please check if this is the correct value.\n", outContent.toString());
    }
}