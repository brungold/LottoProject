package pl.lotto.inputSetting;

import org.junit.jupiter.api.Test;

import java.util.*;

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
    public void should_return_correct_set_of_numbers_when_user_inputs_both_valid_and_invalid_data() {
        // given
        Set<Integer> expectedNumbers = new TreeSet<>(Arrays.asList(1, 2, 3, 99, 6, 10));
        String inputData = "1\n2\n3\n10\npięć\n10\n6\n100\n99\n\n33\n";
        SampleScanner sampleScanner = new SampleScanner() {};
        Scanner scanner = sampleScanner.createSampleScanner(inputData);

        // when
        final Set<Integer> selectedNumbers = userNumbersSet.collectUserNumbers(scanner);

        // then
        assertThat(selectedNumbers).isEqualTo(expectedNumbers);
    }
}