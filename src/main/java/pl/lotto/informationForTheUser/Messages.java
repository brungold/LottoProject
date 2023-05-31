package pl.lotto.informationForTheUser;

/**
 * The Messages class provides static final string variables that store messages used in the lotto game, such as welcome messages, game rules, prompts, and result messages.
 */
public class Messages {
    public static final String WELCOME_MESSAGE = "Welcome in our lottery!";
    public static final String GAME_RULES = "You must enter %d digits from %d to %d. Press the ENTER button after each digit.";
    public static final String GIVE_NUMBER = "Please enter a number.";
    public static final String REPEATED_NUMBER = "You have already entered number %d.";
    public static final String REMAINING_NUMBERS = "Number %d added. %d more numbers needed.";

    public static final String WINNING_MESSAGE = "Congratulations you hit %d digits! Splendidly! You won the grand prize! \n" +
            "Winning numbers were: %s and yours were: %s";
    public static final String HIT_FOUR_OR_FIVE = "You hit %d digits! Congratulations!\n" +
            "Winning numbers were: %s and yours were: %s";
    public static final String LESS_HITS_THAN_FOUR = "You hit %d , unfortunately not this time...\n" +
            "Winning numbers were: %s and yours were: %s";

    public static final String WRONG_NUMBER = "Upsss, please check if this is the correct value.";
}
