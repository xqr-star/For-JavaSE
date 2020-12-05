package 解淇茹18050412115.Test6;

import java.io.*;

public class Test6_FileCopyDemo2 {
    public static void main(String[] args) {
        try {
            // FileReader 文件输入流  在给定从中读取数据的文件名的情况下创建一个新 FileReader。
            //这一句的意思就是以FileReader的对象作为参数，
            // 来创建BufferedReader的对象，这样br这个对象就代表了一个具有缓冲功能的输入流
            BufferedReader br=new BufferedReader(new FileReader("FileCopyDemo2.java"));

            // FileWriter 文件输出流
            BufferedWriter bw=new BufferedWriter(new FileWriter("newFileCopyDemo2.dat"));
            String line=null;
            do {
                line=br.readLine();
                if(null!=line)
                    bw.write(line);
            } while(line!=null);
            br.close();bw.close();
            System.out.println("The file was Copyed!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
