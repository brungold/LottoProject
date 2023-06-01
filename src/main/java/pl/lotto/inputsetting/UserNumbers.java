package pl.lotto.inputsetting;

import java.util.Scanner;
import java.util.Set;

/**
 * The UserNumbers interface defines the contract for classes that collect user numbers in a lotto game.
 * It declares a method for collecting user numbers using a Scanner object.
 */
public interface UserNumbers {
    Set<Integer> collectUserNumbers(Scanner scanner);

}

