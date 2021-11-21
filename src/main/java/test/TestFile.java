package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author fubic
 * @date 2021-05-26
 */
public class TestFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\admin\\Desktop\\testhh\\");
        FileInputStream is = new FileInputStream("C:\\Users\\admin\\Desktop\\testhh\\test.txt");

        boolean success = file.delete();
        System.out.println(success);
    }
}
