package pl.lotto.informationForTheUser;

import java.util.HashMap;
import java.util.Map;

public class ResultMessage {
    private final int result;

    public ResultMessage(int result) {
        this.result = result;
    }

    public String getMessage() {
        Map<Integer, String> messages = new HashMap<>();
        messages.put(6, "Splendidly! Congratulations you won the grand prize!");
        messages.put(5, "You hit 5! Great result!");
        messages.put(4, "You hit 4, nice score!");
        messages.put(3, "You hit half, almost");
        messages.put(2, "You hit 2 digits, unfortunately not this time...");
        messages.put(1, "You hit 1 digits, unfortunately not this time...");
        messages.put(0, "Unfortunately not this time...");

        return messages.entrySet().stream()
                .filter(entry -> entry.getKey() == result)
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse("Ups, we have a glitch, please try again...");

    }
}
