package Lesson1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFile {
    public static void main(String[] args) {
        File dir = new File("E:\\javacode\\Test");
        //List<File> files = listDir(dir);

       List<File> files = listDir2(dir);
        //jdk1.8集合框架使用stream操作 lambda表达式

        files.stream().   //stream 可以提供的操作更多
                forEach(System.out::println);

//        files.
//                forEach(System.out::println);

    }

    public static List<File> listDir2(File dir){
        List <File> list = new ArrayList<>();
        if(dir.isDirectory()) {
            //获取目录下一级的子文件/子文件夹
            File[] children = dir.listFiles();
            if(children != null) {
                for(File file:children){

//                    //返回的文件列表不包含文件夹
//                   if(file.isDirectory()){//如果是子文件夹，递归调用获取
//                       list.addAll(listDir2(file));
//                   }else {
//                       list.add(file);
//                   }
                   //如果包含
                    list.add((file));
                    if(file.isDirectory()){//如果是子文件夹，递归调用获取
                       list.addAll(listDir2(file));
                   }
                }
            }
        }
        return list;
    }




    //将dir下的目录文件全部打印出来
    public static List<File> listDir(File dir){
        List<File> list = new ArrayList<>();//放外面？?
        //如果是一个文件直接返回
        if(dir.isFile()){ // 效率不太高，如果是一个文件返回的就是一个list中只放了一个元素
            return list;
        }
        //如果是文件夹，进行处理
        else if(dir.isDirectory()){
            File[] children = dir.listFiles();
            if(children != null) {
                for(File file:children){
                    list.add(file);
                    List <File> files = listDir(file);
                    list.addAll(files);
                }
            }
        }
        return list;
    }


}
