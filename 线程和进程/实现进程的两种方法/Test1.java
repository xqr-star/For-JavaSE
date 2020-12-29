package Bilibili;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread 实现，实现多线程同步下载图片
public class Test1  implements  Runnable{

    private String url;//网络图片地址
    private String name;//保存的文件名

    public Test1(String url,String name){
        this.url = url;
        this.name = name;
    }


    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownload w = new WebDownload();
        w.downloader(url,name);
        System.out.println("下载了文件名为"+name);
    }


    //学会从网页上扒一张图
    public static void main(String[] args) {
        Test1 t1 = new Test1("https://pic.cnblogs.com/face/1993669/20200811041315.png","1");
        Test1 t2= new Test1("https://pic.cnblogs.com/face/1993669/20200811041315.png","2");
        Test1 t3 = new Test1("https://pic.cnblogs.com/face/1993669/20200811041315.png","3");

        /*t1.start();
        t2.start();
        t3.start();*/


        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();



    }
}

//下载器
class WebDownload{
    //下载方法
    public void downloader(String url,String name)  {
        //把网络上的一个url 变成一个文件
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io 异常 downloader 方法出现问题");
        }
    }

}
