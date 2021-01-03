package Bilibili.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//线程创建方式三- 实现callable 接口

/**
 * Callable 可以定义返回值，可以抛出异常
 */
public class TestCallable implements Callable {
    private String url;//网络图片地址
    private String name;//保存的文件名

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }


    @Override
    //和run 方法的区别是有返回值，返回值类型是object 在这里设置为Boolean
    public Boolean call() {
        WebDownload w = new WebDownload();
        w.downloader(url, name);
        System.out.println("下载了文件名为" + name);
        return true;

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://pic.cnblogs.com/face/1993669/20200811041315.png", "1");
        TestCallable t2 = new TestCallable("https://pic.cnblogs.com/face/1993669/20200811041315.png", "2");
        TestCallable t3 = new TestCallable("https://pic.cnblogs.com/face/1993669/20200811041315.png", "3");

        //创建执行服务：
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行：提交线程 创建服务，通过服务去提交
        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);

        //获取结果： 是call 方法返回的运行结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        //关闭服务:
        ser.shutdownNow();


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
