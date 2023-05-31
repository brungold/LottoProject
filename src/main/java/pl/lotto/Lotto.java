package pl.lotto;

import lombok.Data;
import pl.lotto.engine.ApplicationEngine;
import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.generateNumbers.ResultValidator;
import pl.lotto.generateNumbers.WiningNumbersGenerator;
import pl.lotto.inputSetting.UserNumbers;
import pl.lotto.inputSetting.UserNumbersSet;

import java.util.Scanner;

/**
 * The Lotto class represents the lotto game and implements TheGame interface.
 * It utilizes the ApplicationEngine to start and run the game, using instances of GenerateNumbers, UserNumbers,
 * ResultValidator, and Scanner for gameplay functionality.
 */
@Data
public class Lotto implements TheGame {
    private final GenerateNumbers generateNumbers;
    private final UserNumbers userNumbers;
    private final Scanner scanner;

    public Lotto() {
        generateNumbers = new WiningNumbersGenerator();
        userNumbers = new UserNumbersSet();
        scanner = new Scanner(System.in);
    }

    public void playGame() {
        ApplicationEngine engine = new ApplicationEngine(generateNumbers, userNumbers, new ResultValidator(), scanner);
        String resultMessage = engine.start();
        System.out.println(resultMessage);
    }
}