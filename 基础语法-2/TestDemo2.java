package select;

public class TestDemo2 {

    /**
     * 静态类 里面的main 方法写成静态的
     * 为什么类也得是静态的 静态列的特性
     */
    static class SystemUtil{
        public static boolean isAdmin(String userId){
            return userId.toLowerCase()=="admin";
            //相等表示的是比较对象是否相等



            //return userId.toLowerCase().equals("admin");
            //equals表示的比较对象的内容是否相等。
        }

        public static void main(String[] args){
            //System.out.println(isAdmin("Admin"));

             String str1 = "Hello";
             String str2 = new String("Hello");
             String str3 = str2; // 引用传递
             System.out.println(str1 == str2); // false
             System.out.println(str1 == str3); // false
             System.out.println(str2 == str3); // true
            // equals本身执行的是 == 的作用，但是Strig 中重写了这个方法
             System.out.println(str1.equals(str2)); // true
             System.out.println(str1.equals(str3)); // true
             System.out.println(str2.equals(str3)); // true
        }
    }

}
