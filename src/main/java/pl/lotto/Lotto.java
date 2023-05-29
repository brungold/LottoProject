package pl.lotto;

import pl.lotto.engine.ApplicationEngine;
import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.generateNumbers.ResultValidator;
import pl.lotto.generateNumbers.Validator;
import pl.lotto.generateNumbers.WiningNumbersGenerator;
import pl.lotto.informationForTheUser.Result;
import pl.lotto.informationForTheUser.ResultMessage;
import pl.lotto.inputSetting.UserNumbers;
import pl.lotto.inputSetting.UserNumbersSet;

import java.util.HashSet;
import java.util.Scanner;

public class Lotto{
    public static void main(String[] args) {
        final ApplicationEngine engine = new ApplicationEngine();
        engine.start();
    }
    private static ApplicationEngine getStart() {
        final GenerateNumbers generateNumbers = new WiningNumbersGenerator();
        final UserNumbers userNumbers = new UserNumbersSet();
        final Validator validator = new ResultValidator();
        final ResultMessage resultMessage = new ResultMessage();
        final Scanner scanner = new Scanner(System.in);
    }

}