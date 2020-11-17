package hogwarts.hgwwx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * @Author wangqian
 * @Date 2020-11-16 20:58
 * @Version 1.0
 */
public class DepartPage extends BasePageTest{
    By paro = By.cssSelector(".js_party_info");
    public DepartPage(WebDriver driver) {
        super(driver);
    }
    //搜索部门
    //po原则5 不需要实现所有的方法，按需封装
    public DepartPage searchDepart(String departName){
        //po原则1  用公共方法代表页面所提供的功能
        //po原则3 通常不要在po方法内添加断言

        click(By.id("menu_contacts"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sendKeys(By.id("memberSearchInput"),departName);
        click(By.cssSelector(".ww_icon_AddMember"));
        return this;
    }
    //添加部门
    public DepartPage addDepate(String depaName) throws InterruptedException {
        click(By.id("menu_contacts"));
        Thread.sleep(3000);
        click(By.linkText("添加"));
        click(By.className("js_create_party"));
        sendKeys(By.name("name"),depaName);
        click(By.linkText("选择所属部门"));

        click(By.xpath("(//a[text()=\"爱测吧\"])[2]"));

        click(By.linkText("确定"));

        Thread.sleep(3000);

        return this;
    }

    //删除部门

    public void clearAllDeparts() throws InterruptedException {
        /*searchDepart("aa");*/
        Thread.sleep(3000);

    }



    public String getdepaInfo(){
        String party_name = driver.findElement(By.id("party_name")).getText();
        return party_name;
    }

    public String getPartyInfo(){
        String text = driver.findElement(paro).getText();
        return text;
    }

}
