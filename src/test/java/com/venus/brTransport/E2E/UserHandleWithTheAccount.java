package com.venus.brTransport.E2E;

import com.venus.brTransport.model.User;
import com.venus.brTransport.service.UserService;
import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserHandleWithTheAccount {

    @LocalServerPort
    private Integer port;
    private WebDriver webDriver;
    private String baseUrl;

    @Autowired
    private UserService userService;

    @BeforeAll
    public static void setUpFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUpWebDriver(){
        webDriver=new FirefoxDriver();
        baseUrl="http://localhost:"+port+"/registration";
    }

    @AfterEach
    public void quitWebDriver(){
        if(webDriver!=null){
            webDriver.quit();
        }
    }

    @Test
    public void UserCreateAnAccount(){

        //GIVEN
        webDriver.get(baseUrl);

        final WebElement genderField=webDriver.findElement(By.id("gender"));
        final WebElement lastNameField=webDriver.findElement(By.id("lastName"));
        final WebElement firstNameField=webDriver.findElement(By.id("firstName"));
        final WebElement phoneNumberField=webDriver.findElement(By.id("phoneNumber"));
        final WebElement AdressField=webDriver.findElement(By.id("adress"));
        final WebElement emailField=webDriver.findElement(By.id("email"));
        final WebElement passwordField=webDriver.findElement(By.id("password"));
        final WebElement submitField=webDriver.findElement(By.id("submit"));

        User user=new User();
        user.setGenre("M");
        user.setNom("Hrita");
        user.setPrenom("Oussama");
        user.setTelephone("0668247497");
        user.setAdresse("Hassan, Rabat");
        user.setMail("Oussamahrita11@gmail.com");
        user.setPassword("3#^4FHG$^5");

        //When
        Select select = new Select(genderField);
        select.selectByVisibleText("M");
        lastNameField.sendKeys(user.getNom());
        firstNameField.sendKeys(user.getPrenom());
        phoneNumberField.sendKeys(user.getTelephone());
        AdressField.sendKeys(user.getAdresse());
        emailField.sendKeys(user.getMail());
        passwordField.sendKeys(user.getPassword());
        submitField.click();

        //Then
        Duration duration=Duration.ofSeconds(20);
        final WebDriverWait waiter = new WebDriverWait(webDriver, duration);
        final WebElement solutionElement = waiter.until(
                ExpectedConditions.presenceOfElementLocated(By.id("message")));
        User savedUser= userService.getUserMail(user.getMail());
        assertThat(savedUser).isEqualToIgnoringGivenFields(user,"user_id","operations");


    }

}
