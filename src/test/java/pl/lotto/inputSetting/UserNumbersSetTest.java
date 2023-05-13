package pl.lotto.inputSetting;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserNumbersSetTest implements SampleScanner{

    @Test
    public void testCollectNumbers() {
        String inputData = "1\n2\n3\n4\n5\n6\n";
        UserNumbersSet userNumbersSet = createUserNumbersSet(inputData);

        Set<Integer> selectedNumbers = userNumbersSet.collectNumbers();

        assertEquals(6, selectedNumbers.size());
        assertTrue(selectedNumbers.contains(1));
        assertTrue(selectedNumbers.contains(2));
        assertTrue(selectedNumbers.contains(3));
        assertTrue(selectedNumbers.contains(4));
        assertTrue(selectedNumbers.contains(5));
        assertTrue(selectedNumbers.contains(6));
    }
}