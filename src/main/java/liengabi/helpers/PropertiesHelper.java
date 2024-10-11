package liengabi.helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesHelper { //file này để load file , đọc data, ghi data

    private static Properties properties;
    private static String linkFile;
    private static FileInputStream file;
    private static FileOutputStream out;
    private static String relPropertiesFilePathDefault = "src/test/resources/configs/config.properties";

    public static Properties loadAllFiles() { // đọc nhiều file properties cùng 1 lượt
        LinkedList<String> files = new LinkedList<>(); //linkedlist để lưu những data dạng link
        // Add tất cả file Properties vào đây theo mẫu
        files.add("src/test/resources/configs/config.properties");
        files.add("src/test/resources/configs/local.properties"); //add nhưng link data của properties cụ thể, cú pháp files.add
//        files.add("src/test/resources/configs/production.properties");

        try {
            properties = new Properties(); //properties là class của java , lấy đtg class . những hàm kbao sẵn để xử ly

            for (String f : files) { // dùng vòng lặp for để đọc nhiều file
                Properties tempProp = new Properties();
                linkFile = SystemHelper.getCurrentDir() + f; //dùng class helper để lấy được nhiều link từ ổ đĩa đến thư mục của mình + với link cụ thể f trên kia
                //VD:src/test/resources/configs/config.properties + C:\Users\PC\IdeaProjects\SeleniumTestNG_ParallelExecute để thành C:\Users\PC\IdeaProjects\SeleniumTestNG_ParallelExecute\src\test\resources\configs\config.properties
                file = new FileInputStream(linkFile); // đọc file
                tempProp.load(file); // load file
                properties.putAll(tempProp);// gộp nhiều file lại
            }
            return properties;
        } catch (IOException ioe) {
            return new Properties();
        }
    }

    public static void setFile(String relPropertiesFilePath) { //set 1 file để đường dẫn của file đó vào
        properties = new Properties();
        try {
            linkFile = SystemHelper.getCurrentDir() + relPropertiesFilePath;  // kbao link
            file = new FileInputStream(linkFile); //đọc file
            properties.load(file); //load file
            file.close(); //đóng file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setDefaultFile() { // set file mặc định - hàm phụ dùng cũng đc
        properties = new Properties();
        try {
            linkFile = SystemHelper.getCurrentDir() + relPropertiesFilePathDefault; //đọc link file và lấy biến toàn cục trên
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) { //trong file properties phải đọc qua cái key, sau đó nó sẽ lấy đc cái value tương ứng vs key đó trong file cnfig data
        String value = null;
        try {
            if (file == null) { //if ktra file hiện ti có tồn tại hay k?
                properties = new Properties();
                linkFile = SystemHelper.getCurrentDir() + relPropertiesFilePathDefault;
                file = new FileInputStream(linkFile);
                properties.load(file); // nếu file hiện tại = null load file data mặc định
                file.close();
            }
            // Lấy giá trị từ file đã Set
            value = properties.getProperty(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return value;
    }

    public static void setValue(String key, String keyValue) {
        try {
            if (file == null) { //ktra file chỉ định set vào có null k?
                properties = new Properties();
                file = new FileInputStream(SystemHelper.getCurrentDir() + relPropertiesFilePathDefault);
                properties.load(file);
                file.close();
                out = new FileOutputStream(SystemHelper.getCurrentDir() + relPropertiesFilePathDefault); // chỉ định file xuất ra
            }
            //Ghi vào cùng file Prop với file lấy ra
            out = new FileOutputStream(linkFile); // xuất  ra file output
            System.out.println(linkFile);
            properties.setProperty(key, keyValue);
            properties.store(out, null);
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}