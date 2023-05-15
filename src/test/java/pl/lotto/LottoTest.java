package pl.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.lotto.engine.ApplicationEngine;
import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.generateNumbers.Validator;
import pl.lotto.generateNumbers.WiningNumbersGenerator;
import pl.lotto.informationForTheUser.ResultMessage;
import pl.lotto.inputSetting.User;
import pl.lotto.inputSetting.UserNumbersSet;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class LottoTest {
    private static final Validator validatorMock = mock(Validator.class);
    private static final GenerateNumbers generateNumbersMock = mock(GenerateNumbers.class);
    private static final WiningNumbersGenerator winingNumbersGeneratorMock = mock(WiningNumbersGenerator.class);
    private static final User userMock = mock(User.class);
    private static final UserNumbersSet userNumbersSetMock = mock(UserNumbersSet.class);
    private static final ResultMessage resultMessageMock = mock(ResultMessage.class);
    private static final ApplicationEngine engineMock = mock(ApplicationEngine.class);




    @ParameterizedTest(name = "Test case {index}: {3}")
    @MethodSource("provideUserNumbersAndMessages")
    void shouldReturnCorrectMessageWhenParametersWereGiven(int result,
                                                           Set<Integer> lotteryNumbers,
                                                           Set<Integer> userNumbers,
                                                           String expectedMessage) {

        //given
        when(winingNumbersGeneratorMock.generateWiningNumbers()).thenReturn(lotteryNumbers);
        when(userNumbersSetMock.collectNumbers()).thenReturn(userNumbers);
        ResultMessage resultMessageMock = new ResultMessage(result, lotteryNumbers, userNumbers);
        mockResultValidator(userNumbers, lotteryNumbers);
        String inputData = userNumbers.toString().replaceAll("[\\[\\]\\s]", "")
                .replaceAll("", "\n")
                + "\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());


        // when
        ApplicationEngine engineMock = new ApplicationEngine();
        engineMock.start(inputStream);

        // then
        assertEquals(expectedMessage, resultMessageMock);
    }

    private static Stream<Arguments> provideUserNumbersAndMessages() {
        final Arguments argument1 = Arguments.of(6,
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                "Congratulations you hit 6 digits! Splendidly! You won the grand prize! \n" +
                        "Winning numbers were: [1, 2, 3, 4, 5, 6] and yours were: [1, 2, 3, 4, 5, 6]");

        final Arguments argument2 = Arguments.of(4,
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 15, 16)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                "You hit 4 digits! Congratulations!\n" +
                        "Winning numbers were: [1, 2, 3, 4, 15, 16] and yours were: [1, 2, 3, 4, 5, 6]");

        final Arguments argument3 = Arguments.of(1,
                new HashSet<>(Arrays.asList(1, 12, 13, 14, 15, 16)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                "You hit 1 , unfortunately not this time...\n" +
                        "Winning numbers were: [1, 2, 3, 4, 15, 16] and yours were: [1, 2, 3, 4, 5, 6]");

        return Stream.of(argument1, argument2, argument3);
    }

    private int mockResultValidator(Set<Integer> userNumbers, Set<Integer> winingNumbers) {
        int result = validatorMock.validateNumbers(userNumbers, winingNumbers);
        return result;
    }
}

