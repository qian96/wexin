package hogwarts.hgwwx;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @Author wangqian
 * @Date 2020-11-16 20:58
 * @Version 1.0
 */
public class MainPage extends BasePageTest{

    void login() throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame");

        Thread.sleep(20000);
        Set<Cookie> cookies = driver.manage().getCookies();

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        mapper.writeValue(new File("cookies.yaml"),cookies);

        //System.exit(0);
    }
    @BeforeAll
    void beforeAll()  throws IOException, InterruptedException {
        File file = new File("cookies.yaml");
        if(file.exists()){
            driver = new ChromeDriver();
            driver.get("https://work.weixin.qq.com/wework_admin/frame");
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            TypeReference typeReference = new TypeReference<List<HashMap<String,Object>>>() {};

            List<HashMap<String,Object>> cookies = (List<HashMap<String, Object>>) mapper.readValue(file,typeReference);
            System.out.println(cookies);

            cookies.forEach(cookieMap->{
                driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(),cookieMap.get("value").toString()));
            });
            driver.navigate().refresh();
        }else{

            login();
        }

    }

    public MainPage() throws IOException, InterruptedException {
        //初始化session，并复用session
        this.beforeAll();
    }

    public DepartPage contack(){
        click(By.id("menu_contacts"));
        //po原则4 跳转或者进入新页面使用返回新的po来模拟
        return new DepartPage(driver);
    }
    public MemberPage MemberPage(){
        click(By.id("menu_contacts"));
        //po原则4 跳转或者进入新页面使用返回新的po来模拟
        return new MemberPage(driver);
    }
}
