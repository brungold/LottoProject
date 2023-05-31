package pl.lotto.engine;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.generateNumbers.ResultValidator;
import pl.lotto.generateNumbers.Validator;
import pl.lotto.generateNumbers.WiningNumbersGenerator;
import pl.lotto.informationForTheUser.ResultMessage;
import pl.lotto.inputSetting.UserNumbers;
import pl.lotto.inputSetting.UserNumbersSet;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationEngineTest {
    private static final Scanner scannerMock = new Scanner(System.in);
    private static final Validator validatorMock = mock(ResultValidator.class);
    private static final UserNumbers userNumbersMock = mock(UserNumbersSet.class);
    private static final GenerateNumbers generateNumbersMock = mock(WiningNumbersGenerator.class);
    private static final ResultMessage resultMessage = mock(ResultMessage.class);

    @ParameterizedTest(name = "player hit {0} digits, random numbers were {1}, player numbers were {2}, result {3}")
    @MethodSource("provideNumbersAndMessages")
    void shouldReturnCorrectMessageWhenParametersWereGiven(Integer hitsCount,
                                                           Set<Integer> playerGivenNumbers,
                                                           Set<Integer> randomNumbers,
                                                           String expectedMessage) {
        // given
        mockNumbers(playerGivenNumbers, randomNumbers);
        mockHitCount(randomNumbers, playerGivenNumbers, hitsCount);
        ApplicationEngine engine = new ApplicationEngine(generateNumbersMock, userNumbersMock, validatorMock, scannerMock);
        // when
        String result = engine.start();
        // then
        assertEquals(expectedMessage, result);
    }

    private static Stream<Arguments> provideNumbersAndMessages() {
        final Arguments argument1 = Arguments.of(6, Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                "Congratulations you hit 6 digits! Splendidly! You won the grand prize! \n" +
                        "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 5, 6]");

        final Arguments argument2 = Arguments.of(4, Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 11, 12))),
                "You hit 4 digits! Congratulations!\n" +
                        "Winning numbers were: [1, 2, 3, 4, 11, 12] and yours were: [1, 2, 3, 4, 5, 6]");

        final Arguments argument3 = Arguments.of(1, Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 8, 9, 10, 11, 12))),
                "You hit 1 , unfortunately not this time...\n" +
                        "Winning numbers were: [1, 8, 9, 10, 11, 12] and yours were: [1, 2, 3, 4, 5, 6]");

        return Stream.of(argument1, argument2, argument3);
    }

    private void mockNumbers(Set<Integer> playerGivenNumbers, Set<Integer> randomNumbers) {
        when(userNumbersMock.collectUserNumbers(scannerMock)).thenReturn(playerGivenNumbers);
        when(generateNumbersMock.generateWiningNumbers()).thenReturn(randomNumbers);
    }

    private void mockHitCount(Set<Integer> randomNumbers, Set<Integer> playerGivenNumbers, int hitsCount) {
        when(validatorMock.validateNumbers(randomNumbers, playerGivenNumbers)).thenReturn(hitsCount);
    }
}