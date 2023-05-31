package pl.lotto;

/**
 * The StartGame class contains the main method that starts the lotto game
 * by creating an instance of the Lotto class and calling the playGame method.
 */
public class StartGame {
    public static void main(String[] args) {
        TheGame lotto = new Lotto();
        lotto.playGame();
    }
}
