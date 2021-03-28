package 线性表.双链表;

//循环双链表类
public class CirDoubleList<T> {

    public DoubleNode<T> head;

    public CirDoubleList() {
        this.head = new DoubleNode<T>();
        this.head.prev = this.head;
        this.head.next = this.head;
    }

    //判断是否为空
    public boolean isEmpty(){
        return this.head.next == this.head;
    }

    //指定位置插入
    public DoubleNode<T> insert(int i,T x){
        if (x == null)
            return null;
        DoubleNode<T> front = this.head;
        for (int j = 0; front.next != this.head && j < i; j++)
            front = front.next;

        DoubleNode<T> q = new DoubleNode<T>(x,front,front.next);
        front.next.prev = q;
        front.next = q;
        return q;
    }

    //尾插入
    public DoubleNode<T> insert(T x){
        if (x == null)
            return null;
        DoubleNode<T> q = new DoubleNode<T>(x,head.prev,head);
        head.prev.next = q;
        head.prev = q;
        return q;
    }

    //删除
    public T remove(int i){
        DoubleNode<T> p = this.head.next;
        for (int j = 0; p != this.head && j < i ; j++)
            p = p.next;
        if (p != head && i >=0){
            p.prev.next = p.next;
            p.next.prev = p.prev;
            return p.data;
        }
        return null;
    }

    //合并
    public void concat(CirDoubleList<T> list){
        DoubleNode<T> p = this.head.next;
        for (int j = 0; p != this.head ; j++)
            p = p.next;
        if (p == head){
            DoubleNode<T> rear = this.head.prev;
            rear.next = list.head.next;
            list.head.prev.next = this.head;
            list.head.next.prev = rear;
            this.head.prev = list.head.prev;
        }
    }

    //循环双链表的深拷贝
    public void copy(CirDoubleList<T> list){
        DoubleNode<T> rear = this.head;
        DoubleNode<T> p = list.head.next;
        while (p != list.head){
            rear.prev.next = rear;
            rear.next = new DoubleNode<T>(p.data,rear,this.head);
            rear = rear.next;
            p = p.next;
        }
        rear.prev.next = rear;
    }

    @Override
    public String toString() {
        String str = this.getClass().getName()+"(";
        for (DoubleNode<T> p = this.head.next; p != this.head; p = p.next)
            str += p.data.toString()+(p.next != this.head ? "," : "");
        return str + ")";
    }
}
