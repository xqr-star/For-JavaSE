class Teacher2 implements Comparable <Teacher2> {
    String name;
    int age;
    int height;
    int weight;

    public Teacher2(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    //大小关系如何决定留给开发者
    public int compareTo(Teacher2 o) {

        if (this.age > o.age) {
            return 1;
        } else if  (this.age == o.age) {
            return 0;
        } else {
            return -1;
        }
    }
}
    public class ComparableDemo {

        public static void main(String[] args) {
            Teacher2 t1 = new Teacher2("GAO",18,180,60);
            Teacher2 t2 = new Teacher2("LAO",38,170,80);
            int r = t1.compareTo(t2);
            if(r>0) {
                System.out.println("gao > lao");
            }
            if(r<0) {
                System.out.println("gao < lao");
            }
            if(r==0) {
                System.out.println("gao == lao");
            }

        }

    }


