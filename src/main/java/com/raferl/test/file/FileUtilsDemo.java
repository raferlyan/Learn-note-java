package com.raferl.test.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;

/**
 * @author raferlyan
 * @date 2022/10/3 21:14
 **/
public class FileUtilsDemo {
    public static void main(String[] args) {
        demo04();
    }

    /**
     * 写入文件
     */
    public static void demo01(){
        try {
            FileUtils.writeByteArrayToFile(new File("src/main/resources/test.txt"), "test".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读文件
     */
    public static void demo02(){
        byte[] bytes;
        try {
            bytes = FileUtils.readFileToByteArray(new File("src/main/resources/test.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("读取到的文本为：" + new String(bytes));
    }

    /**
     * 创建文件
     */
    public static void demo03(){
        File myfile = new File("src/main/resources/myfile.txt");
        try {
            FileUtils.touch(myfile);
            if (myfile.exists()) {
                System.out.println("The file exists");
            } else {
                System.out.println("The file does not exist");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除文件
     */
    public static void demo04(){
        File myfile = new File("src/main/resources/myfile.txt");
        FileUtils.deleteQuietly(myfile);
        if (myfile.exists()) {
            System.out.println("The file exists");
        } else {
            System.out.println("The file does not exist");
        }
    }

    /**
     * 根据文件路径获取文件
     *
     * @param filePath 文件路径
     * @return 文件
     */
    public static File getFileByPath(String filePath) {
        return StringUtils.isEmpty(filePath) ? null : new File(filePath);
    }
}
