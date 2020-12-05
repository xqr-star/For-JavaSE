package 解淇茹18050412115.Test6;
import java.io.File;
import java.io.IOException;

public class Test6_FileCreateAndDelDemo {

    public static void main(String[] args) {
        File file = new File("Hello.txt"); // 创建一个文件类型对象 默认在当前项目文件夹下创建一个文件
        File dir = new File("c://creatDir");//在 c 盘的根目录下创建一个文件夹
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件夹否存在：" + dir.exists());

        if (!file.exists()) {
            try {
                file.createNewFile(); // 如果文件不存在则创建一个新的文件
            } catch (IOException e) { e.printStackTrace();
            }
        }
        if (!dir.exists()) {
            dir.mkdir(); // 如果文件夹不存在，则创建一个文件夹
        }
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件夹否存在：" + dir.exists());
        System.out.println("文件的绝对路径是：" + file.getAbsolutePath());
        System.out.println("文件夹的绝对路径是：" + dir.getAbsolutePath());


        file.delete(); // 删除文件
        dir.delete();//删除文件夹
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件夹是否存在：" + dir.exists());
    }

}
