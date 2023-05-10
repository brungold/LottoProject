package pl.lotto.engine;


import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.generateNumbers.WiningNumbersGenerator;
import pl.lotto.informationForTheUser.Messeges;
import pl.lotto.informationForTheUser.ResultMessage;
import pl.lotto.inputSetting.*;
import pl.lotto.generateNumbers.ResultValidator;

import java.io.InputStream;
import java.util.Set;

import pl.lotto.inputSetting.InputData;
import pl.lotto.inputSetting.InputDataFromUser;
import pl.lotto.inputSetting.NumberRange;
import pl.lotto.inputSetting.NumberVerifier;
import pl.lotto.inputSetting.UserNumbersSet;

public class ApplicationEngine {

    public static void start(InputStream inputStream) {
        displayWelcomeMessage();
        InputData inputData = new InputDataFromUser(inputStream);
        Set<Integer> winningNumbersSet = generateWinningNumbers();
        Set<Integer> userNumbers = getUserNumbers(inputData);
        int result = validateResult(winningNumbersSet, userNumbers);
        displayResultMessage(result, userNumbers, winningNumbersSet);
    }

    private static void displayWelcomeMessage() {
        System.out.println(Messeges.WELCOME_MESSAGE);
    }

    private static Set<Integer> generateWinningNumbers() {
        GenerateNumbers generateNumbers = new WiningNumbersGenerator();
        return generateNumbers.generateWiningNumbers();
    }

    private static Set<Integer> getUserNumbers(InputData inputData) {
        NumberRange numberRange = new RangeVerifier();
        VerifyNumbers verifyNumbers = new NumberVerifier();
        User user = new User();
        UserNumbersSet userNumbersSet = new UserNumbersSet(inputData, numberRange, verifyNumbers, user);
        return userNumbersSet.collectNumbers();
    }

    private static int validateResult(Set<Integer> winningNumbersSet, Set<Integer> userNumbers) {
        ResultValidator resultValidator = new ResultValidator();
        return resultValidator.validateNumbers(winningNumbersSet, userNumbers);
    }

    private static void displayResultMessage(int result, Set<Integer> userNumbersSet, Set<Integer> winningNumbers) {
        ResultMessage resultMessage = new ResultMessage(result, userNumbersSet, winningNumbers);
        String message = resultMessage.getMessage(result, userNumbersSet, winningNumbers);
        System.out.println(message);
    }
}

//    public void start() {
//        displayWelcomeMessage();
//        Set<Integer> userNumbersSet = getUserNumbersSet();
//        Set<Integer> winningNumbers = getWiningNumbers();
//        int result = getResult();
//        getResultMessage(result, userNumbersSet, winningNumbers);
//    }
//

//
//    private Set<Integer> getUserNumbersSet() {
//        InputDataFromUser inputData = new InputDataFromUser(System.in);
//        User user = new User();
//        NumberRange numberRange = new RangeVerifier();
//        VerifyNumbers verifyNumbers = new NumberVerifier();
//        UserNumbersSet userNumbersSet = new UserNumbersSet(inputData, user, numberRange, verifyNumbers);
//        return userNumbersSet.collectNumbers();
//    }
//
//    private Set<Integer> getWiningNumbers() {
//        WiningNumbersGenerator generateNumbers = new WiningNumbersGenerator();
//        return generateNumbers.generateWiningNumbers();
//    }
//
//    private int getResult() {
//        Validator validator = new ResultValidator();
//        return validator.validateNumbers(getUserNumbersSet(), getWiningNumbers());
//    }
//
//    private ResultMessage getResultMessage(int result, Set<Integer> userNumbersSet, Set<Integer> winningNumbers) {
//        ResultMessage resultMessage = new ResultMessage(result, userNumbersSet, winningNumbers);
//        String message = resultMessage.getMessage(result, userNumbersSet, winningNumbers);
//        System.out.println(message);
//        return resultMessage;
//    }
//}
