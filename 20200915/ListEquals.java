import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person{
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        //判断引用O的是不是不是Person 的实例
        if(! (o instanceof Person)) {
            return false;
        }
        Person  p = (Person)o;
        return this.id == p.id;
    }


}
public class ListEquals {
    public static void main(String[] args) {

        Person p1 = new Person(1,"gao");
        Person p2 = new Person(1,"gao");

        List<Person> list = new ArrayList<>();

        list.add(p1);//链表里面放的是一个Person类型的引用

        System.out.println(list);
        System.out.println(list.contains(p1));
        //不重写equal 和重写的结果比较
        //System.out.println(list.contains(p2)); false
        System.out.println(list.contains(p2));//true;


    }

}
