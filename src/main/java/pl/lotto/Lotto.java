package pl.lotto;

import pl.lotto.engine.ApplicationEngine;

public class Lotto {
    public static void main(String[] args) {
        ApplicationEngine engine = new ApplicationEngine();
        engine.start(System.in);
    }
}