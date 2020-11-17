package hogwarts.hgwwx;

import hogwarts.hgwwx.Util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Author wangqian
 * @Date 2020-11-16 21:00
 * @Version 1.0
 */
public class BasePageTest {
    WebDriver driver;

    public BasePageTest(WebDriver driver) {
        this.driver=driver;
    }

    public BasePageTest() {
    }


    void click(By by){
        driver.findElement(by).click();
    }

    void sendKeys(By by,String content){
        driver.findElement(by).sendKeys(content);
    }

    By GetByLocal(String key){
        ProUtil pro = new ProUtil("element.properties");
        String Locator = pro.GetPro(key);
        String locatorBy = Locator.split(">")[0];
        String locatorValue = Locator.split(">")[1];
        if(locatorBy.equals("id")){
          return By.id(locatorValue);
        }else if(locatorBy.equals("name")){
          return By.name(locatorValue);
        }else if(locatorBy.equals("linkText")){
          return By.linkText(locatorValue);
        }else if(locatorBy.equals("cssSelector")){
          return By.cssSelector(locatorValue);
        }else if(locatorBy.equals("className")){
          return By.className(locatorValue);
        }else{
          return By.xpath(locatorValue);
        }
    }
}
