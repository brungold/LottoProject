package pl.lotto.generateNumbers;

import org.junit.jupiter.api.Test;
import pl.lotto.dataSetting.NumbersSetting;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WiningNumbersGeneratorTest {
    @Test
    public void should_generate_wining_numbers_uniqueness() {
        //given
        WiningNumbersGenerator winingNumbersGenerator = new WiningNumbersGenerator();

        //when
        Set<Integer> winingNumbersSet = winingNumbersGenerator.generateWiningNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(winingNumbersSet);

        //then
        assertEquals(NumbersSetting.NUMBER_OF_NUMBERS, winingNumbersSet.size());
        assertEquals(winingNumbersSet.size(), uniqueNumbers.size());
    }

    @Test
    public void should_generate_wining_numbers_range() {
        // given
        GenerateNumbers winingNumbersGenerator = new WiningNumbersGenerator();
        int expectedSize = NumbersSetting.NUMBER_OF_NUMBERS;
        int minNumber = NumbersSetting.BOTTOM_LIMIT;
        int maxNumber = NumbersSetting.TOP_LIMIT;

        // when
        Set<Integer> winingNumbers = winingNumbersGenerator.generateWiningNumbers();

        // then
        assertNotNull(winingNumbers);
        assertEquals(expectedSize, winingNumbers.size());

        for (int number : winingNumbers) {
            assertTrue(number >= minNumber && number <= maxNumber);
        }
    }

    @Test
    public void should_generate_wining_numbers_returns_numbers_in_random_order() {
        // given
        GenerateNumbers winingNumbersGenerator = new WiningNumbersGenerator();

        // when
        Set<Integer> winingNumbers1 = winingNumbersGenerator.generateWiningNumbers();
        Set<Integer> winingNumbers2 = winingNumbersGenerator.generateWiningNumbers();

        // then
        assertNotEquals(winingNumbers1, winingNumbers2);
    }
}