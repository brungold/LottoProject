package pl.lotto.engine;


import lombok.Data;
import pl.lotto.generatenumbers.NumbersGenerable;
import pl.lotto.generatenumbers.NumbersValidable;
import pl.lotto.informationfortheuser.Messages;
import pl.lotto.informationfortheuser.ResultMessage;
import pl.lotto.inputsetting.*;

import java.util.Scanner;
import java.util.Set;

/**
 * The ApplicationEngine class serves as the main engine of the lotto game.
 * It generates winning numbers, collects user numbers, validates the numbers, and returns the game result as a message.
 */
@Data
public class ApplicationEngine {
    private final NumbersGenerable numbersGenerable;
    private final UserNumbers userNumbers;
    private final NumbersValidable numbersValidable;
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
        final Set<Integer> winningNumbers = numbersGenerable.generateWiningNumbers();
        final int result = numbersValidable.validateNumbers(winningNumbers, numbersFromUser);
        return new ResultMessage(result, numbersFromUser, winningNumbers);
    }
}

