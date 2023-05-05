package pl.lotto.inputSetting;
import pl.lotto.dataSetting.NumbersSetting;

public class RangeVerifier implements NumberRange{
    @Override
    public boolean isInRange(int number) {
        return (number >= NumbersSetting.BOTTOM_LIMIT) && (number <= NumbersSetting.TOP_LIMIT);
    }
}
