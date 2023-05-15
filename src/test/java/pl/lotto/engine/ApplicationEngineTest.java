package pl.lotto.engine;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.generateNumbers.Validator;
import pl.lotto.informationForTheUser.ResultMessage;
import pl.lotto.inputSetting.*;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationEngineTest {
    private static final UserNumbersSet userNumbersSetMock = mock(UserNumbersSet.class);
    private static final ResultMessage resultMessage = mock(ResultMessage.class);
    private static final Validator validatorMock = mock(Validator.class);
    private static final GenerateNumbers generateNumbersMock = mock(GenerateNumbers.class);


    @ParameterizedTest(name = "Congratulations you hit {0} digits! Splendidly! You won the grand prize! \n" +
            "Winning numbers were: {2} and yours were: {1}")

    @MethodSource("provideUserNumbersAndMessages")
    void shouldReturnCorrectMessageWhenParametersWereGiven(int result , Set<Integer> winningNumbers, Set<Integer> userNumbers, String expectedMessage) {
        // given
        mockNumbers(userNumbers, winningNumbers);
        mockResultValidator(userNumbers, winningNumbers);

        // when
        ApplicationEngine engine = new ApplicationEngine();
        engine.start(System.in);

        // then
        assertEquals(expectedMessage, resultMessage.getMessage(result, winningNumbers, userNumbers));
    }

    private static Stream<Arguments> provideUserNumbersAndMessages() {
        final Arguments argument1 = Arguments.of(6,
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                "Congratulations you hit 6 digits! Splendidly! You won the grand prize! \n" +
                        "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 5, 6]");

//        final Arguments argument2 = Arguments.of(4,
//                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
//                new HashSet<>(Arrays.asList(1, 2, 3, 4, 15, 16)),
//                "You hit 4 digits! Congratulations!\n" +
//                        "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 10, 12]");
//
//        final Arguments argument3 = Arguments.of(1,
//                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
//                new HashSet<>(Arrays.asList(1, 12, 13, 14, 15, 16)),
//                "You hit 1 , unfortunately not this time...\n" +
//                        "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 10, 12]");

        return Stream.of(argument1 );
                //,argument2, argument3
    }

    private void mockNumbers(Set<Integer> userNumbers, Set<Integer> winingNumbers) {
        when(userNumbersSetMock.collectNumbers()).thenReturn(userNumbers);
        when(generateNumbersMock.generateWiningNumbers()).thenReturn(winingNumbers);
    }

    private int mockResultValidator(Set<Integer> userNumbers, Set<Integer> winingNumbers) {
        int result = validatorMock.validateNumbers(userNumbers, winingNumbers);
        return result;
    }
}