package tests.api_ui_oauth.ui.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {

     private static  String token ="";


    @Test
    private void processLogin()throws Exception{
        WebElement emailTextField = driver.findElement(By.name("email"));
        WebElement passwordTextField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        emailTextField.sendKeys("test@test.com");
        passwordTextField.sendKeys("password");
        loginButton.click();
        Thread.sleep(2000);
        setToken(driver.getCurrentUrl().split("=")[1].split("&")[0]);
        System.out.println(token);

    }

    public void setToken(String tokenUrlThatWeGot){
        token = tokenUrlThatWeGot;
    }

    public String getToken(){
        return token;
    }
}
