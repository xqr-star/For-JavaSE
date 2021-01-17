package Lesson1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class apiTest {
    public static void main(String[] args) {
        String path = "E:\\javacode";
        String name = "\\File-IO";  // 下面会把字符串进行拼接操作，随意不能省略//
        String pathname = path+name;

        //File file = new File("E:\\javacode\\File-IO");
         File file = new File(pathname);


//        boolean flag = file.exists();
//        System.out.println(pathname+"文件"+flag);

//        boolean flag1 = file.isDirectory();
//        System.out.println(flag1);
//
//        boolean flag2 = file.isFile();
//        System.out.println(flag2);


        File file2 = new File("E:\\javacode\\File-IO\\Test2.txt");
        if(file2.exists()){
            //如果没有却删除，会返回false
            boolean flag = file2.delete();
            System.out.println(flag);

        }else {
            System.out.println("文件不存在");
        }


        boolean flag;

        //创建新文件 -- 如果有了返回false
        File file3 = new File("E:\\javacode\\File-IO\\Test3.txt");
        if(!file3.exists()){
            try {
               flag= file3.createNewFile();
                System.out.println(flag);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件已经存在了");
        }

        File file4 = new File("E:\\javacode\\Test\\Test1");
        flag = file4.mkdir();
        System.out.println("没有Test目录，是否创建"+flag);

        //没有Test目录，创建，同时在Test目录下创建Test1目录
        File file5 = new File("E:\\javacode\\Test\\Test1");
        flag = file5.mkdirs();
        System.out.println("没有Test目录，是否创建"+flag);


        File file6 = new File("E:\\javacode\\Test");
        System.out.println(file6.getParent());//获取父目录路径
        System.out.println(file6.getPath());//获取相对路径
        System.out.println(file6.getAbsolutePath());//获取绝对路径
        System.out.println(file6.getName());//获取文件名

        System.out.println(file6.getParentFile());

        File file7 = new File("E:\\javacode\\Test\\Test1");
        System.out.println(Arrays.toString(file7.listFiles()));


    }

}
