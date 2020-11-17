package hogwarts.hgwwx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @Author wangqian
 * @Date 2020-11-16 20:59
 * @Version 1.0
 */
public class MemberPage extends BasePageTest {
    public MemberPage(WebDriver driver) {

        super(driver);
    }
    //po原则6 添加成功与添加失败返回的页面不同，需要封装不同的方法
    public MemberPage addMemberFaile(String username, String acctid, String mobile) {
        return this;
    }
    //po原则6 添加成功与添加失败返回的页面不同，需要封装不同的方法
    public MemberPage addMember(String username, String acctid, String mobile) {
        driver.findElements(By.cssSelector(".index_service_cnt_item_title")).get(0).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sendKeys(GetByLocal("addusername"),username);

        sendKeys(GetByLocal("addacctid"),acctid);

        sendKeys(GetByLocal("addalias"),mobile);

        driver.findElements(GetByLocal("addsave")).get(1).click();

        return this;

    }

    public MemberPage searchMember(String username){
        click(GetByLocal("searid1"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sendKeys(GetByLocal("searid2"),username);
        //click(driver.findElement(By.id("")));
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        return this;
    }

    public MemberPage editMember(String newusername, String newalias){
        searchMember("22");
        click(GetByLocal("ediMemli"));
        driver.findElement(GetByLocal("ediMemName1")).clear();
        sendKeys(GetByLocal("ediMemName2"),newusername);

        driver.findElement(GetByLocal("ediMemNme3")).clear();
        sendKeys(GetByLocal("ediMemNme3"),newalias);

        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        /*driver.findElements(By.cssSelector(".ww_commonImg_SmallGrayMore")).get(0);

        click(By.linkText("删除"));
*/
        click(By.linkText("保存"));
        return this;
    }

    public MemberPage deleteMember() throws InterruptedException {
        //click(By.className("member_colRight_memberTable_th_Checkbox"));
        Thread.sleep(3000);
        driver.findElements(By.cssSelector(".ww_checkbox")).get(0).click();
        click(By.linkText("删除"));

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("确认")));
        click(By.linkText("确认"));
       return this;
    }

    public MemberPage forbiddenMember(){
        click(By.linkText("置顶"));
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        //driver.switchTo().alert().accept();
        return this;
    }

   public String getMemName11(){
       String memberName = driver.findElement(By.xpath("(//span[@class=\"ww_commonCntHead_title_inner_text\"])[2]")).getText();
       return memberName;
   }
}
