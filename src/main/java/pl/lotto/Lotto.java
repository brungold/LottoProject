package pl.lotto;

import pl.lotto.engine.ApplicationEngine;
import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.generateNumbers.ResultValidator;
import pl.lotto.generateNumbers.WiningNumbersGenerator;
import pl.lotto.informationForTheUser.ResultMessage;
import pl.lotto.inputSetting.UserNumbers;
import pl.lotto.inputSetting.UserNumbersSet;

import java.util.Scanner;

public class Lotto implements StartGame{
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.start();
    }

    @Override
    public ResultMessage start() {
        Scanner scanner = new Scanner(System.in);
        GenerateNumbers generator = new WiningNumbersGenerator();
        UserNumbers userNumbers = new UserNumbersSet();
        ResultValidator validator = new ResultValidator();
        ApplicationEngine engine = new ApplicationEngine(new ResultMessage(), validator, generator, userNumbers, scanner);
        ResultMessage result = engine.start();
        scanner.close();
        return result;
    }
}