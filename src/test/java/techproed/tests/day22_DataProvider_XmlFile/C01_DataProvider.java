package techproed.tests.day22_DataProvider_XmlFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProvider {


    /*
        DataProvider; bir çok veriyi test caselerde loop kullanmadan aktarmak için kullanırız.
    Bunun için öncelikle parametreli @Test methodumuzu oluştururuz. @Test notasyonundan sonra
    parametre olarak dataProvider yazarız ve oluşturulacak dataProvider notasyonuna sahip methoda
    bir isim veririz(dataProvider="araclar"). @DataProvider notasyonuna sahip method 2 boyutlu Object Array
    return eder.

     */
    @DataProvider
    public static Object[][] araclar() {
        return new Object[][]{{"mercedes"},{"bmw"},{"audi"},{"volvo"},{"tesla"}};
    }

    @Test(dataProvider = "araclar")
    public void test01(String data) {
        System.out.println(data);
    }
}
