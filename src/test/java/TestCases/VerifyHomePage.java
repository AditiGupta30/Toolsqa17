package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utility.BaseClass;
import pages.HomePage;
import pages.Login;


public class VerifyHomePage extends BaseClass {

@Test
public void verifyAccountLink()
{
  HomePage home = PageFactory.initElements(driver, HomePage.class);
  
  home.clickonAccountLink();


Login LoginPage = PageFactory.initElements(driver, Login.class);

LoginPage.logintoApplication();

}
}

