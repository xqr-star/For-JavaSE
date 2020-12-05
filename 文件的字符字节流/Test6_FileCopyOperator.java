package 解淇茹18050412115.Test6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test6_FileCopyOperator {

    public static void main(String args[]) throws IOException {
        String byteFilename = "byteFile.dat";
        String copyFilename = "copyByteFile.dat";
        //创建文件输入流对象
        FileInputStream fin = new FileInputStream(byteFilename);
        //创建文件输出流对象
        FileOutputStream fout = new FileOutputStream(copyFilename, false);
        //append参数为true时，数据从文件尾部写入；append参数为false时，数据覆盖原文件。
        byte[] buffer = new byte[512];          //字节缓冲区
        int count = 0;
        do {
            count = fin.read(buffer);            //读取输入流
            if (count != -1) {
                fout.write(buffer);               //写入输出流
            }
        } while (count != -1);

        fin.close();                               //关闭输入流
        fout.close();                              //关闭输出流

        System.out.println("Copyfile from " + byteFilename + " to " + copyFilename);
    }
}
