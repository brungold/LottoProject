package pl.lotto.engine;


import lombok.Data;
import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.generateNumbers.Validator;
import pl.lotto.informationForTheUser.Messages;
import pl.lotto.informationForTheUser.ResultMessage;
import pl.lotto.inputSetting.*;

import java.util.Scanner;
import java.util.Set;


@Data
public class ApplicationEngine{
    private final ResultMessage resultMessage;
    private final Validator validator;
    private final GenerateNumbers generateNumbers;
    private final UserNumbers userNumbers;
    private final Scanner scanner;

    public ResultMessage start() {
        displayWelcomeMessage();
        processNumbers();
        resultMessage.getMessage();
    }

    private static void displayWelcomeMessage() {
        System.out.println(Messages.WELCOME_MESSAGE);
    }

    private ResultMessage processNumbers() {
        final Set <Integer> numbersFromUser = userNumbers.collectUserNumbers(scanner);
        final Set <Integer> winningNumbers = generateNumbers.generateWiningNumbers();
        return validator.validateNumbers(numbersFromUser, winningNumbers);
    }
}

