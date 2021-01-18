package Lesson2;

import java.io.*;

public class FileInput {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\javacode\\Test\\Test1\\1.txt");


        //1.文件输入字节流
        //FileInputStream fis = new FileInputStream("D:\\QQ\\1159641785\\FileRecv\\20201201.png");
        FileInputStream fis = new FileInputStream(file);
        //给定初始化的数组大小
        byte[] bytes = new byte[1024];
        //从输入流里面去读,读取到字节数组里面去

        int length = 0;
        //你的返回值类似是int 所以定义一个int遍历 ,把读取的数据的长度  //固定套路
        //读取一个字节/字符数组.定义read 的返回值遍历,while

        // 读取到的长度数组可能读满了,也可能没读满,当此读取,一般使用数组[0,len]
        while ((length = fis.read(bytes))  != -1 ){
//            fis.read();//参数按一个字节读取,或者读取字节数组 // 查一下参数
            String str = new String(bytes,0,length); // 把字节数组转换成字符串 // 只是模拟
            System.out.println(str);
        }
        //输入输出流,使用完一定要关闭,且是反向关闭 和创建的顺序相反
        fis.close();





       // 2.文件输入字符流
        FileReader fr = new FileReader(file);

        char[] chars = new char[1024];
        int length = 0;
        while ((length = fr.read(chars)) != -1){
            String str = new String(chars,0,length); // 把字节数组转换成字符串 // 只是模拟
            System.out.println(str);
        }


        //3.缓冲流:缓冲的字节输入/缓冲的字符输入
        FileInputStream fis = new FileInputStream(file); // 文件字节输入流
        //字节流转字符流,一定要经过字节字符转换流来操作,并且可以定制编码
        //和文件编码格式要一致才不是乱码
        InputStreamReader isr = new InputStreamReader(fis); // 第二个参数传递编码格式,不穿就是自己的环境的编码

       //缓冲的字符输入流
        BufferedReader br = new BufferedReader(isr);
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }

        //反向释放资源
        br.close();
        isr.close();
        fis.close();



       // 4.缓冲流:缓冲的字节输入/缓冲的字符输入
        FileInputStream fis2 = new FileInputStream(file); // 文件字节输入流
        //缓冲的字节输入流
        BufferedInputStream bis = new BufferedInputStream(fis2);
        //后面的代码和字节输入流操作类似,操作byte[] --之后的代码补充完成

        //给定初始化的数组大小
        byte[] bytes = new byte[1024];
        //从输入流里面去读,读取到字节数组里面去

        int length = 0;
        while ((length =bis.read(bytes))  != -1 ){
            String str = new String(bytes,0,length);
            System.out.println(str);
        }




    }
}

