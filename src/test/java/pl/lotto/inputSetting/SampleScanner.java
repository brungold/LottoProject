package pl.lotto.inputSetting;

import java.util.Scanner;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public interface SampleScanner {

    default Scanner createSampleScanner(String data) {
        InputStream input = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(input);
        return scanner;
    }
}

