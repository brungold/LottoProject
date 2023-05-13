package pl.lotto.inputSetting;

import java.util.Scanner;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public interface SampleScanner {

    default InputData createInputData(String data) {
        InputStream input = new ByteArrayInputStream(data.getBytes());
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputData inputData = new InputDataFromUser(input);
        System.setIn(input);
        return inputData;
    }

    default UserNumbersSet createUserNumbersSet(String data) {
        InputData inputData = createInputData(data);
        return new UserNumbersSet(inputData, new RangeVerifier(), new NumberVerifier(), new User());
    }
}

