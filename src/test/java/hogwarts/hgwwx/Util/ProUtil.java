package hogwarts.hgwwx.Util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author wangqian
 * @Date 2020-11-17 10:52
 * @Version 1.0
 */
public class ProUtil {

    public Properties pro;

    public ProUtil(String File) {
        pro = ReadProperties(File);
    }

    private Properties ReadProperties(String File) {
        Properties properties = new Properties();
        String user;

        try {
            FileInputStream fileInputStream = new FileInputStream(File);
            BufferedInputStream in = new BufferedInputStream(fileInputStream);
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  properties;
    }
    public String GetPro(String key){
        String value;
         if(pro.containsKey(key)){
             value = pro.getProperty(key);
             return value;
         } else{
            return "";
         }

    }
    public static void main(String[] args) {
        ProUtil Prol = new ProUtil("element.properties");
        System.out.println(Prol.GetPro("username"));
    }
}
