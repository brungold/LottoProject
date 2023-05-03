package pl.lotto.inputSeting;

import org.junit.jupiter.api.Test;
import pl.lotto.dataSetting.NumbersSetting;

import static org.junit.jupiter.api.Assertions.*;

class RangeVerifierTest {
    @Test
    public void given_number_within_range_when_isInRange_then_returns_true() {
        // given
        RangeVerifier rangeVerifier = new RangeVerifier();
        int number = NumbersSetting.BOTTOM_LIMIT + 1;

        // when
        boolean result = rangeVerifier.isInRange(number);

        // then
        assertTrue(result);
    }

    @Test
    public void given_number_below_range_when_isInRange_then_returns_false() {
        // given
        RangeVerifier rangeVerifier = new RangeVerifier();
        int number = NumbersSetting.BOTTOM_LIMIT - 1;

        // when
        boolean result = rangeVerifier.isInRange(number);

        // then
        assertFalse(result);
    }

    @Test
    public void given_number_above_range_when_isInRange_then_returns_false() {
        // given
        RangeVerifier rangeVerifier = new RangeVerifier();
        int number = NumbersSetting.TOP_LIMIT + 1;

        // when
        boolean result = rangeVerifier.isInRange(number);

        // then
        assertFalse(result);
    }
}