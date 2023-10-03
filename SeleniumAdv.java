package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SeleniumAdv extends Driver{

    @Test
    public void radioButton() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input[value='radio1']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[value='radio2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[value='radio3']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void textArea() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("Bangladesh");
        Thread.sleep(2000);
    }

    @Test
    public void dropdown() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#dropdown-class-example")).click();
        driver.findElement(By.cssSelector("option[value='option1']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#dropdown-class-example")).click();
        driver.findElement(By.cssSelector("option[value='option2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#dropdown-class-example")).click();
        driver.findElement(By.cssSelector("option[value='option3']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#dropdown-class-example")).click();
        driver.findElement(By.cssSelector("option:nth-child(1)")).click();
        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
        dropdown.click();
        Select select = new Select(dropdown);
        for(int i=0 ; i<4; i++){
            select.selectByIndex(i);
            System.out.println(select.getFirstSelectedOption().getText());
            Thread.sleep(3000);
        }
        Thread.sleep(3000);
    }

    @Test
    public void checkbox() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#checkBoxOption1")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#checkBoxOption2")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#checkBoxOption3")).click();
        System.out.println("Option3 clicked: "+ driver.findElement(By.cssSelector("#checkBoxOption3")).isSelected());
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#checkBoxOption3")).click();
        System.out.println("Option3 clicked: "+ driver.findElement(By.cssSelector("#checkBoxOption3")).isSelected());
        driver.findElement(By.cssSelector("#checkBoxOption2")).click();
        driver.findElement(By.cssSelector("#checkBoxOption1")).click();
        Thread.sleep(2000);
    }

    @Test
    public void tabSwitch() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#openwindow")).click();
        List <String> tabList = new ArrayList<>(driver.getWindowHandles());

        System.out.println(tabList.get(1));
        driver.switchTo().window(tabList.get(1));
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.close();

        System.out.println(tabList.get(0));
        driver.switchTo().window(tabList.get(0));
        System.out.println(driver.getTitle());
        driver.findElement(By.cssSelector("#opentab")).click();
        String newTabHandle = getNewTabHandle(tabList);
        tabList.add(newTabHandle);

        System.out.println(tabList.get(2));
        driver.switchTo().window(tabList.get(2));
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.close();

        System.out.println(tabList.get(0));
        driver.switchTo().window(tabList.get(0));
        System.out.println(driver.getTitle());
        driver.navigate().refresh();

        System.out.println(tabList);
        Thread.sleep(5000);
    }

    @Test
    public void elementShowHide() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#displayed-text")).sendKeys("Hello!!!");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#hide-textbox")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#show-textbox")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.cssSelector("#displayed-text")).getAttribute("value"));
        driver.findElement(By.cssSelector("#displayed-text")).clear();
        Thread.sleep(1500);
    }

    @Test
    public void mouseHOver() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Actions action = new Actions(driver);
        WebElement hover = driver.findElement(By.cssSelector("#mousehover"));
        action.moveToElement(hover).perform();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[href='#top']")).click();
        Thread.sleep(3000);

        action.moveToElement(hover).perform();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Reload")).click();
        Thread.sleep(1000);
    }

    @Test
    public void mouseHOver2() throws InterruptedException {
        driver.get("https://demoqa.com/menu#");
        Actions action = new Actions(driver);
        WebElement hover = driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
        action.clickAndHold(hover).build().perform();
        Thread.sleep(3000);
        action.clickAndHold(driver.findElement(By.xpath("//a[normalize-space()='SUB SUB LIST »']"))).build().perform();
        Thread.sleep(3000);
    }

    @Test
    public void scrollUD() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector(\".tableFixHead\").scroll(0,100)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector(\".tableFixHead\").scroll(100,0)");
        Thread.sleep(2000);

    }

    @Test
    public void iframe() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1100)");
        Thread.sleep(2000);
        driver.switchTo().frame("courses-iframe");

        js.executeScript("window.scroll(0,300)");
        Thread.sleep(3000);
        js.executeScript("window.scroll(300,600)");
        Thread.sleep(3000);
        js.executeScript("window.scroll(600,300)");

        driver.findElement(By.cssSelector("a[href = 'practice-project']")).click();
        Thread.sleep(3000);
        js.executeScript("window.scroll(0,300)");
        Thread.sleep(3000);
        js.executeScript("window.scroll(300,600)");
        Thread.sleep(3000);

        driver.findElement(By.linkText("Home")).click();
        Thread.sleep(3000);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

    }


    @Test
    public void footer() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1300)");
        Thread.sleep(2000);
        driver.findElement(By.linkText("REST API")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back();
        js.executeScript("window.scroll(1300,0)");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }

    @Test
    public  void alertHandling() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.cssSelector(".analystic[href='#OKTab']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn.btn-danger")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert 1");
        System.out.println(alert.getText());
        alert.accept();
        System.out.println("---------------------------------");

        driver.findElement(By.cssSelector(".analystic[href='#CancelTab']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(3000);
        System.out.println("Alert 2");
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(driver.findElement(By.cssSelector("#demo")).getText());
        Thread.sleep(1000);
        System.out.println("---------------------------------");

        driver.findElement(By.cssSelector(".analystic[href='#Textbox']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn.btn-info")).click();
        System.out.println("Alert 3");
        Thread.sleep(3000);
        System.out.println(alert.getText());
        alert.sendKeys("Captain America !!!");
        alert.accept();
        System.out.println(driver.findElement(By.cssSelector("#demo1")).getText());
        Thread.sleep(1000);
    }

    @Test
    public void selectOption() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Selectable.html");
       driver.findElement(By.cssSelector(".analystic[href='#Default']")).click();
        Thread.sleep(2000);
        WebElement list = driver.findElement(By.cssSelector("div[id='Default'] li:nth-child(3)"));
        Actions actions = new Actions(driver);
        actions.click(list).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".analystic[href='#Serialize']")).click();
        Thread.sleep(2000);
        WebElement ulList = driver.findElement(By.xpath("//div[@id='Default']//ul[@class='deaultFunc']"));
        Thread.sleep(2000);
        WebElement itemToSelect1 = ulList.findElement(By.xpath("//div[@id='Serialize']//li[3]"));
        WebElement itemToSelect2 = ulList.findElement(By.xpath("//div[@id='Serialize']//li[4]"));
        WebElement itemToSelect3 = ulList.findElement(By.xpath("//div[@id='Serialize']//li[5]"));
        Thread.sleep(2000);
        actions.keyDown(Keys.CONTROL).click(itemToSelect1).click(itemToSelect2).click(itemToSelect3).build().perform();
        Thread.sleep(3000);
    }

    private String getNewTabHandle(List<String> oldHandles) {
        Set<String> currentHandles = new HashSet<>(driver.getWindowHandles());
        currentHandles.removeAll(oldHandles);
        return currentHandles.iterator().next();
    }

}
