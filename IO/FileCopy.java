package Lesson2;

import java.io.*;

public class FileCopy {
    //文件复制
    public static void main(String[] args) throws IOException {
        File input = new File("E:\\javacode\\File-IO\\Test1.txt");


        //指定一个文件做输出操作
        File output = new File("E:\\javacode\\Test\\copyFile.txt");
        if(!output.exists()){
            output.createNewFile();
        }
        //定义输入输出流
        //--处理输入
        //按照二进制字节读取
        FileInputStream fis  = new FileInputStream(input);  // 因为这里的参数只能传递一个文件copy操作必须要指定一个文件而不是文件夹
//        //缓冲流  两种都可以,只是涉及到包裹东西
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(input));
        FileOutputStream fos = new FileOutputStream(output);

        long start = System.currentTimeMillis();
        //接受输入
        byte[] bytes = new byte[1024];
        int len = 0;
        //每次从输入流读取到byte[] 的内容,直接输出到某个文件按,就是复制
        while ( (len = fis.read(bytes)) != -1){
           // fos.write(bytes); 不能直接输出整个byte数组
            fos.write(bytes,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        fis.close();
        fos.close();


//        //完成缓冲的字节输入和字节输出
//        new BufferedInputStream(new FileInputStream());
//
//        new BufferedOutputStream(new FileOutputStream());


    }
}
