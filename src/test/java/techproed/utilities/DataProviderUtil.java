package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider
    public Object[][] veriler() {
        return new Object[][]{{"mustafa"},{"topal"}};
    }
}
