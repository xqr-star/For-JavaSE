package 解淇茹18050412115.Test6;
import java.io.File;
public class Test6_IteratorFilesDemo {
    public static void main(String[] args) {
        File file = new File("C://users"); // 获取Users目录对象

        if (file.exists()) { // 如果文件或目录存在
            String[] files = file.list(); // 获取目录下的文件和目录的名称
            for (String fileName : files) {
                System.out.println(fileName);
            }

            System.out.println("***********************************");
            File[] subFiles = file.listFiles(); // 获取文件列表
            for(File f : subFiles) {
                if (f.isDirectory()) { // 如果时目录
                    System.out.println("|— " + f.getName());
                } else { // 如果时文件
                    System.out.println(" - " + f.getName());
                }
            }
        }else System.out.println("There is no files and dirs!");

    }
}
