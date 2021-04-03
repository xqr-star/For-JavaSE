package bite.GC;

//新生代分配在Eden区
public class 参数测试1 {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];//Eden
        System.out.println(1);
        allocation2 = new byte[2 * _1MB];//Eden
        System.out.println(2);
        allocation3 = new byte[2 * _1MB];//Eden
        System.out.println(3);
        // 出现Minor GC
        allocation4 = new byte[4 * _1MB];
        System.out.println(4);
    }

    public static void main(String[] args) throws Exception {
        testAllocation();
    }
}
