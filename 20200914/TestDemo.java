import java.util.Objects;

class Teacher  {
    String name;
    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        //1.this 不是NUll 检查Object 是不是null
        if(obj == null ) {
            return false;
        }
        //2.instanceof  判断obj 引用 是不是Teacher类的实例
        if(!(obj instanceof Teacher)){
            return false;
        }
        //3.根据设计类的目的来判断对象是否代表同一个事物
        //此处只要名字一样就代表一个事物。
        Teacher teacherObj = (Teacher)obj; //向下转型
        return this.name.equals(teacherObj.name);//这里调用的equals
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("gao");
        Teacher t2 = new Teacher("gao");
        Teacher t3 = new Teacher("lao");
        Teacher t4 = new Teacher("lao");
        System.out.println(t1.equals(t2));
        System.out.println(t1.equals(t3));


    }





}
