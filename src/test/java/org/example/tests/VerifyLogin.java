//package org.example.tests;
//
//import org.example.base.BaseTest;
//import org.example.pages.LoginPage;
//import org.example.utils.ExcelReader;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.io.FileNotFoundException;
//
//public class VerifyLogin extends BaseTest {
//
//    @Test(dataProvider = "excelData")
//    public void login(String usernameexcel, String passwdexcel) throws FileNotFoundException {
//        LoginPage lp = new LoginPage(driver);
//
//        lp.login(usernameexcel, passwdexcel);
//    }
//
//    @DataProvider(name = "excelData")
//    public Object [][] getData(){
//        return ExcelReader.readExcel("src/test/resources/LoginData.xlsx", "Login");
//    }
//
//    LoginPage loginPage =
//            new LoginPage(driver);
//
//
//
//
//
//}
