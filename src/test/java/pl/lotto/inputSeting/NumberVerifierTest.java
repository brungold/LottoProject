package pl.lotto.inputSeting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberVerifierTest {
    private VerifyNumbers verifier = new NumberVerifier();

    @Test
    void should_return_true_for_number_string() {
        // given
        String input = "123";

        // when
        boolean result = verifier.isNumber(input);

        // then
        assertTrue(result);
    }

    @Test
    void should_return_false_for_non_number_string() {
        // given
        String input = "abc";

        // when
        boolean result = verifier.isNumber(input);

        // then
        assertFalse(result);
    }

    @Test
    void should_return_false_for_null_input() {
        // given
        String input = null;

        // when
        boolean result = verifier.isNumber(input);

        // then
        assertFalse(result);
    }
}