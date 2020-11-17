package hogwarts.hgwwx;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author wangqian
 * @Date 2020-11-16 21:00
 * @Version 1.0
 */
public class PoTest extends BasePageTest {
    private static MainPage mainPage;
    @BeforeAll
    static void beforeAll() throws IOException, InterruptedException {
        mainPage = new MainPage();
       //删除数据
    }
    @Test
    public void addMem(){

        mainPage.MemberPage().addMember("005","210093","000@qq.com");
    }

    @Test
    public void searMember(){
        String memName11 = mainPage.MemberPage().searchMember("22").getMemName11();
        assertTrue(memName11.equals("成员详情"));
    }

    @Test
    public void editMember(){
        mainPage.MemberPage().editMember("666","60@qq.com");
    }

    @Test
    public void forbiddenMem(){
        mainPage.MemberPage().searchMember("99").forbiddenMember();
    }
    @Test
    public void deleteMem() throws InterruptedException {
        mainPage.MemberPage().deleteMember();
    }
    @Test
    public void search() throws IOException, InterruptedException {
        //打开页面
        //复用session
        //MainPage mainPage = new MainPage();
        //跳转页面
        //部门搜索
        String dd = mainPage.contack().searchDepart("财务部").getPartyInfo();

        assertTrue(dd.contains("无任何成员"));

    }
    @Test
    public void addDep() throws InterruptedException {
        String aa = mainPage.contack().addDepate("c").getdepaInfo();

        assertTrue(aa.equals("c"));
    }

}
