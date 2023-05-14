package pl.lotto.engine;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.lotto.Main;
import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.informationForTheUser.ResultMessage;
import pl.lotto.inputSetting.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationEngineTest {
    private static final UserNumbersSet userNumbersSetMock = mock(UserNumbersSet.class);
    private static final ResultMessage resultMessage = mock(ResultMessage.class);

    @ParameterizedTest(name = "shouldReturnCorrectMessageWhenParametersWereGiven({0})")
    @MethodSource("provideUserNumbersAndMessages")
    void shouldReturnCorrectMessageWhenParametersWereGiven(Set<Integer> userNumbers, String expectedMessage) {
        // given
        mockUserNumbers(userNumbers);

        // when
        ApplicationEngine.start(null);

        // then
        assertEquals(expectedMessage, resultMessage.getMessage());
    }

    private static Stream<Arguments> provideUserNumbersAndMessages() {
        final Arguments argument1 = Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                "Congratulations you hit 6 digits! Splendidly! You won the grand prize! \n" +
                        "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 5, 6]");

        final Arguments argument2 = Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4)),
                "You hit 4 numbers! Winning numbers were [1, 2, 3, 4, 5, 6], and yours were [1, 2, 3, 4]");

        final Arguments argument3 = Arguments.of(new HashSet<>(Collections.singletonList(1)),
                "You hit 1 numbers! Winning numbers were [1, 2, 3, 4, 5, 6], and yours were [1]");

        return Stream.of(argument1, argument2, argument3);
    }

    private void mockUserNumbers(Set<Integer> userNumbers) {
        when(userNumbersSetMock.getUserNumbers()).thenReturn(userNumbers);
        when(resultMessage.getMessage()).thenReturn("Test message");
    }
}