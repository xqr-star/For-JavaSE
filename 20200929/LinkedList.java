package impl.stack;

//实现Deque 接口
public class LinkedList implements Deque {
    private static class Node {
        private Integer v;
        Node previous;
        Node next;
        Node(Integer v) {
            this.v = v;
        }
    }
    private  Node head;
    private  Node tail;
    private  int size;

    @Override
    public boolean offerFirst(Integer e) {
        Node cur = new Node(e);
        if(size == 0) {
            head = tail = cur;
        } else {
            cur.next=head;
            head.previous = cur;
            head = cur;
        }
        size++;
        return true;
    }

    @Override
    public Integer peekFirst() {
        if(size == 0) {
            return null;
        }
        return head.v;
    }

    @Override
    public Integer pollFirst() {
        if(size == 0) {
            return null;
        }
        int a = head.v;
        head = head.next;
        if(head != null) {
            head.previous = null;
        }else {
            tail =null;
        }
        size--;
        return a;
    }

    @Override
    public boolean offerLast(Integer e) {
        Node cur = new Node(e);
        if(size == 0) {
            head = tail =cur;
        }else  {
            tail.next = cur;
            cur.previous =tail;
            tail =cur;
        }
        size++;
        return true;
    }

    @Override
    public Integer peekLast() {
        if(size == 0) {
            return null ;
        }else  {
            return head.v;
        }
    }

    @Override
    public Integer poolLast() {

        if(size == 0) {
            return null ;
        }
        int a=tail.v;
       if(tail != head) {
           tail = tail.previous;
           tail.next = null;
        }else {
            head = tail =null;
        }
//
//        tail = tail.previous;
//        if (tail != null) {
//            tail.next = null;
//        } else {
//            head = null;
//        }
        size--;
        return a;
    }
}
