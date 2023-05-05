package pl.lotto.inputSetting;

public class NumberVerifier implements VerifyNumbers{
    @Override
    public boolean isNumber(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
