package techproed.tests.day21_SmokeTest_Excel;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C03_ExcelTest {
    @Test
    public void testTest() {
        String dosyaYolu="src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaIsmi="customer_info";
        ExcelReader excelReader=new ExcelReader(dosyaYolu,sayfaIsmi);
        System.out.println(excelReader.getCellData(1, 0));
        String email=excelReader.getCellData(1, 0);
        String password=excelReader.getCellData(1, 1);
        System.out.println(email+" || " +password);
    }
}
