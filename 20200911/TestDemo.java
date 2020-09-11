
class Node {
    public int val;
    public Node next;
}
public class TestDemo {

    Node head;
    //采用头插法逆置
    public void addFirst(int data) {
        Node cur =new Node();
        cur.val = data;
        cur.next = head;
        head = cur;

    }
    public static Node reverse1(Node head) {
        Node newHead = null;//链表的新的头结点
        Node prev =null;//结点的前驱
        Node cur = head;//当前需要反转的链表的结点

        while (cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        //循环跳出后，相当于cur==null 所有结点均已经逆置
       return newHead;
    }
    public  static void display(Node head) {
        Node cur = head;
        while(cur !=null) {
            System.out.print(cur.val);
            cur=cur.next;
        }
    }

    public static void main(String[] args) {
        // 构造一个 1 2 3 4 的链表
        Node head = new Node();
        head.val=1;

        head.next = new Node();
        head.next.val=2;

        head.next.next = new Node();
        head.next.next.val=3;

        head.next.next.next = new Node();
        head.next.next.next.val=4;
        display(head);
        System.out.println();


        // 逆置链表
        Node reverseHead = reverse1(head); //定义一个引用 指向 返回的Newhead对象


        // 打印链表
        display(reverseHead);

    }

    //代码风格不好  = 左右两边加上空格
}



