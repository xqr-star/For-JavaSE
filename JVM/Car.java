package classloder;

import java.lang.reflect.InvocationTargetException;

public class Car {


    public String name = "宝马";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //通过反射类实例化对象
        Class<Car> carClass = Car.class;
        Car car = carClass.newInstance();

        //实例化对象
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        //三个对象是不同的
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());
        //获取模板的class
        //三个对象反射的class是一个



        //获取当前类的类加载器
        //其实本质都是要getClassLoader只是因为在这之前要先获取class字节码文件，由于获取class字节码的不同所以会不同
        //第一种通过
        System.out.println(Car.class.getClassLoader());
        //第二种
        Class<? extends Car> Class = car1.getClass();
        ClassLoader classLoader = Class.getClassLoader();
        System.out.println(classLoader);//AppClassLoader 应用程序加载器



        System.out.println(classLoader.getParent());//ExtClassLoader 扩展类加载器


        //原因是java调用不到这里不是说ExtClassLoader没有父加载器，
        // 而是因为Bootstrap ClassLoader使用C++写的。
        System.out.println(classLoader.getParent().getParent()); //null

    }
 }
