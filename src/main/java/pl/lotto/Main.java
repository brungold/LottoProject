package pl.lotto;

import pl.lotto.engine.ApplicationEngine;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        ApplicationEngine engine = new ApplicationEngine();
        engine.start(System.in);
    }
}