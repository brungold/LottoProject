package pl.lotto;

import pl.lotto.engine.ApplicationEngine;
import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.generateNumbers.ResultValidator;
import pl.lotto.generateNumbers.Validator;
import pl.lotto.generateNumbers.WiningNumbersGenerator;
import pl.lotto.inputSetting.UserNumbers;
import pl.lotto.inputSetting.UserNumbersSet;

import java.util.Scanner;

public class Lotto{
    public static void main(String[] args) {
        GenerateNumbers generateNumbers = new WiningNumbersGenerator();
        UserNumbers userNumbers = new UserNumbersSet();
        Scanner scanner = new Scanner(System.in);

        ApplicationEngine engine = new ApplicationEngine(generateNumbers, userNumbers, new ResultValidator(), scanner);
        String resultMessage = engine.start();
        System.out.println(resultMessage);

        scanner.close();
    }
}