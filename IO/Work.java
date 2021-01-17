package Lesson1;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//遍历某个目录下所有的子文件--包括孙子辈
public class Work {
    public static void main(String[] args) {
        List<File[]> list = new LinkedList<>();

        File file = new File("E:\\javacode");

        遍历(file,list);

        //输出list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }
    }

    /**
     * 链表的每一个元素是一个数组，数组里面的每一个值都是file.listFiles获取到的
     * 所以不断的改变file.listFiles 中的file 然后加入到数组中即可
     * @param file 路径
     * @param list 链表
     */
    private static void 遍历(File file, List<File[]> list) {
        if(file.listFiles() == null) {
            return;
        }
        list.add(file.listFiles());

        //传进去的路径就是数组里面每一个元素的路径
        for(int i= 0;i<file.listFiles().length;i++){
            File[] arr = file.listFiles();
            遍历(arr[i],list);
        }
    }
}
