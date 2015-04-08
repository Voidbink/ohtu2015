package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkeep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.clear();
        element.sendKeys("jaakko");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkeeppi");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");  
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("back to home"));       
        element.click();
        
        System.out.println( driver.getPageSource() );
        
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
        
        System.out.println( driver.getPageSource() );
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("marko1");
        element = driver.findElement(By.name("password"));
        element.sendKeys("tilipitappi2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("tilipitappi2");
        element = driver.findElement(By.name("add"));
        element.click();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        System.out.println( driver.getPageSource() );
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        System.out.println( driver.getPageSource() );
        
    }
}
