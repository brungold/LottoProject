package pl.lotto.engine;

import pl.lotto.dataSetting.NumbersSetting;
import pl.lotto.generateNumbers.WiningNumbersGenerator;
import pl.lotto.informationForTheUser.Messeges;
import pl.lotto.informationForTheUser.ResultMessage;
import pl.lotto.inputSetting.*;
import pl.lotto.generateNumbers.Validator;
import pl.lotto.generateNumbers.ResultValidator;

import java.util.Set;

public class ApplicationEngine {
    public void start() {
        displayWelcomeMessage();
        displayGameRules();
        getUserNumbersSet();
        getWiningNumbers();
        getResult();
        getResultMessage(getResult(), getUserNumbersSet(), getWiningNumbers());
    }

    private void displayWelcomeMessage() {
        System.out.println(Messeges.WELCOME_MESSAGE);
    }

    private void displayGameRules() {
        System.out.printf(Messeges.GAME_RULES, NumbersSetting.NUMBER_OF_NUMBERS, NumbersSetting.BOTTOM_LIMIT, NumbersSetting.TOP_LIMIT);
        System.out.println();
    }

    private Set<Integer> getUserNumbersSet() {
        InputDataFromUser inputData = new InputDataFromUser(System.in);
        NumberRange numberRange = new RangeVerifier();
        VerifyNumbers verifyNumbers = new NumberVerifier();
        UserNumbersSet userNumbersSet = new UserNumbersSet(inputData, numberRange, verifyNumbers);
        return userNumbersSet.getUserNumbers();
    }

    private Set<Integer> getWiningNumbers() {
        WiningNumbersGenerator generateNumbers = new WiningNumbersGenerator();
        return generateNumbers.generateWiningNumbers();
    }

    private int getResult() {
        Validator validator = new ResultValidator();
        return validator.validateNumbers(getUserNumbersSet(), getWiningNumbers());
    }

    private ResultMessage getResultMessage(int result, Set<Integer> userNumbersSet, Set<Integer> winningNumbers) {
        ResultMessage resultMessage = new ResultMessage(result, userNumbersSet, winningNumbers);
        String message = resultMessage.getMessage(result, userNumbersSet, winningNumbers);
        System.out.println(message);
        return resultMessage;
    }
}
