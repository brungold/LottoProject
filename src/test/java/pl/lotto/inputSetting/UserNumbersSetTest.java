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
    public void should_return_numbers_in_set_when_all_in_range_1_to_99() {
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
    public void should_return_numbers_in_set_when_one_not_in_range() {
        // given
        Set<Integer> expectedNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1,2,3,4,5,6)));
        String inputData = "1\n2\n3\n4\n5\n100\n6\n";
        Scanner userNumbers = createSampleScanner(inputData);

        // when
        final Set<Integer> selectedNumbers = userNumbersSet.collectUserNumbers(userNumbers);

        // then
        assertThat(expectedNumbers).isEqualTo(selectedNumbers);
    }
    @Test
    void should_return_message_wrong_number_because_of_provided_string() {
        // given
        String expectedMessage = "Upsss, please check if this is the correct value.\n";
        String inputData = "pięć\n";
        Scanner userNumbers = createSampleScanner(inputData);

        // when
        final Set<Integer> selectedNumbers = userNumbersSet.collectUserNumbers(userNumbers);

        // then
        assertTrue(selectedNumbers.isEmpty());
        assertEquals(expectedMessage, Messages.WRONG_NUMBER);
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
}