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
public class ApplicationEngine {
    private final GenerateNumbers generateNumbers;
    private final UserNumbers userNumbers;
    private final Validator validator;
    private final Scanner scanner;

    public String start() {
        try {
            displayWelcomeMessage();
            ResultMessage resultMessage = getGameResult();
            return resultMessage.getMessage();
        } finally {
            scanner.close();
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println(Messages.WELCOME_MESSAGE);
    }

    private ResultMessage getGameResult() {
        final Set<Integer> numbersFromUser = userNumbers.collectUserNumbers(scanner);
        final Set<Integer> winningNumbers = generateNumbers.generateWiningNumbers();
        final int result = validator.validateNumbers(winningNumbers, numbersFromUser);
        return new ResultMessage(result, numbersFromUser, winningNumbers);
    }
}

