package pl.lotto.inputSeting;

import java.io.InputStream;
import java.util.Scanner;

public class InputDataFromUser implements InputData {
    private final Scanner scanner;

    public InputDataFromUser(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public void close() {
        scanner.close();
    }

    public String inputFromUser() {
        return scanner.next();
    }
}
