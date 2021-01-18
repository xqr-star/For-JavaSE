package Lesson2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOutput {
    public static void main(String[] args) throws IOException {

        //路径上没有该文件,new File不会报错,但是操作输入输出流会抛出FileNotFoundException

        File file2 = new File("E:\\javacode\\Test\\1.txt");
        //a-z 换行输出到某一个文件
        //但这个文件可能存在也可能不存在,需要考虑
        if(!file2.exists()){
            file2.createNewFile();
        }
        //可以使用字节或者字符输出
        //但是使用字符输出更好操作
        //new FileWriter 不带缓冲的字符输出
        // new FileOutputStream  文件字节输出/
        // / new BufferedWriter( 带缓冲的字符输出
        //new PrintWriter()

//        //类似输入的几种写法都可以
//        BufferedWriter bw = new BufferedWriter(new FileWriter(file2)); // 可以直接使用new FileWriter(file2) 也可以包裹
//       //
//        bw.write("\n");

        //传递的参数 是Writer /Stream
//        PrintWriter pw  = new PrintWriter(new FileWriter(file2) );
        PrintWriter pw  = new PrintWriter(new FileOutputStream(file2));

        //快速打印a-z  int a = (int) 'a';  可以写成下面的,他前面是灰色的
        //这个操作不太熟悉
        int a = 'a';
        for(int i = 'a';i <= 'z';i++){
            pw.println((char) i);
        }
        pw.flush();
        pw.close();

    }
}
