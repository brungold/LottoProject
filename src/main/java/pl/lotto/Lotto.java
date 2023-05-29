package pl.lotto;

import pl.lotto.engine.ApplicationEngine;
import pl.lotto.generateNumbers.GenerateNumbers;
import pl.lotto.generateNumbers.ResultValidator;
import pl.lotto.generateNumbers.WiningNumbersGenerator;
import pl.lotto.informationForTheUser.ResultMessage;
import pl.lotto.inputSetting.UserNumbers;
import pl.lotto.inputSetting.UserNumbersSet;

import java.util.Scanner;

public class Lotto{
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.start();
    }


}