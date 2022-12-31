package com.luo.java3;

import org.junit.Test;

import java.io.File;

/**
 * @author luozstart
 * @create 2022-12-21 14:31
 */
public class FileTest {
    /*
    1.如何创建File实例

    2.
    相对路径：相较于某个路径下，指明的路径。
    绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
    windows：\\
    unix：/
     */
    @Test
    public void test1(){
        //构造器1
        File file = new File("hello.txt");//相对于当前module
        File file2 = new File("E:\\idea_project1\\StudyJava\\Day25\\he.txt");//绝对路径

        System.out.println(file);
        System.out.println(file2);

        //构造器2：
        File file3 = new File("E:\\idea_project1", "StudyJava");
        System.out.println(file3);

        //构造器3：
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);
    }

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("F:\\IO\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }
    @Test
    public void test3(){
        File file = new File("E:\\idea_project1\\StudyJava");

        String[] list = file.list();
        for (String s :list){
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for (File f :files){
            System.out.println(f);
        }
    }

    @Test
    public void test4(){
        File file1 =new File("hello.txt");
        File file2 =new File("E:\\IO\\hi.txt");
        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);
    }
}
