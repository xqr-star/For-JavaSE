import java.util.ArrayList;
import java.util.List;


public class ListDemo {
    public static void main(String[] args) {
        //泛型
        List<String> list = new ArrayList<>() ;

        //List<String> list1 =new List<String>() ;
        //为什么不能这样写？？？
        //List 是一个接口 接口不能实例化


        list.add("hell0");
        list.add("world");
        list.add("xqr");
        list.add("fighting");
        System.out.println(list);
        System.out.println(list.size());
        list.add(4,"hhh");
        System.out.println(list);
        //list.add(8,"jjj"); //下标越界

        list.remove(1);
        System.out.println(list);
        list.remove("hhh");
        System.out.println(list);
        list.remove("gfc");//remove 的返回值是boolean
        System.out.println(list.remove("gfc"));

        System.out.println(list);
        System.out.println(list.size());

        //返回此列表中指定位置的元素。所以必须sout
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        list.set(3,"gfc");
        System.out.println(list);
        System.out.println(list.isEmpty());

        list.clear();
        System.out.println(list);
        System.out.println(list.size());

        System.out.println(list.isEmpty());

        System.out.println(list.contains("jjj"));
        System.out.println(list.contains("gfc"));
        System.out.println(list);

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        System.out.println(list);

        System.out.println(list.indexOf("a"));
        System.out.println(list.lastIndexOf("a"));
        System.out.println(list.indexOf("b"));
        System.out.println(list.indexOf("f"));
        System.out.println(list.lastIndexOf("f"));





    }

}
