package pl.lotto.engine;


import lombok.Data;
import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.generateNumbers.Validator;
import pl.lotto.generateNumbers.WiningNumbersGenerator;
import pl.lotto.informationForTheUser.Messages;
import pl.lotto.informationForTheUser.ResultMessage;
import pl.lotto.inputSetting.*;
import pl.lotto.generateNumbers.ResultValidator;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

import pl.lotto.inputSetting.InputData;
import pl.lotto.inputSetting.InputDataFromUser;
import pl.lotto.inputSetting.NumberRange;
import pl.lotto.inputSetting.NumberVerifier;
import pl.lotto.inputSetting.UserNumbersSet;
@Data

public class ApplicationEngine {
    private final ResultMessage resultMessage;
    private final Validator validator;
    private final GenerateNumbers generateNumbers;
    private final UserNumbers userNumbers;
    private final Scanner scanner;

    public void start(InputStream inputStream) {
        displayWelcomeMessage();
        processNumbers();
    }

    private static void displayWelcomeMessage() {
        System.out.println(Messages.WELCOME_MESSAGE);
    }

    private ResultMessage processNumbers() {
        final Set <Integer> numbersFromUser = userNumbers.collectUserNumbers(scanner);
        final Set <Integer> winningNumbers = generateNumbers.generateWiningNumbers();
        return validator.validateNumbers(numbersFromUser, winningNumbers);
    }

    private static void displayResultMessage(int result, Set<Integer> userNumbersSet, Set<Integer> winningNumbers) {
        ResultMessage resultMessage = new ResultMessage(result, userNumbersSet, winningNumbers);
        String message = resultMessage.getMessage(result, userNumbersSet, winningNumbers);
        System.out.println(message);
    }
}

