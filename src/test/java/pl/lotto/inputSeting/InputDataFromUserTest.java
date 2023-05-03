package pl.lotto.inputSeting;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputDataFromUserTest {
    @Test
    void should_return_one_digit() {
        //given
        String inputString = "1";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        InputDataFromUser input = new InputDataFromUser(inputStream);
        String expectedOutPut = "1";

        //when
        String actualOutPut = input.inputFromUser();

        //then
        assertEquals(expectedOutPut, actualOutPut);

        input.close();
    }

    @Test
    void should_return_one_digit_when_two_digits_provided() {
        //given
        String inputString = "1 2";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        InputDataFromUser input = new InputDataFromUser(inputStream);
        String expectedOutPut = "1";

        //when
        String actualOutPut = input.inputFromUser();

        //then
        assertEquals(expectedOutPut, actualOutPut);

        input.close();
    }

    @Test
    void should_return_one_digit_when_six_digits_provided() {
        //given
        String inputString = "1 7 23 56 57 85 ";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        InputDataFromUser input = new InputDataFromUser(inputStream);
        String expectedOutPut = "1 7 23 56 57 85";

        //when
        String actualOutPut = input.inputFromUser();

        //then
        assertNotEquals(expectedOutPut, actualOutPut);

        input.close();
    }
}