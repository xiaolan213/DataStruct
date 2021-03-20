package 线性表.单链表;

//单链表类 继承object
public class SinglyList<T> extends Object {

    public Node<T> head;//头指针,指向单链表的头节点

    //构造方法
    public SinglyList() {//构造空链表
        this.head = new Node<T>();//创建节点头 data和head均为Null
    }

    //构造单链表,尾插入val数组元素,忽略其中的空对象
    public SinglyList(T[] values){
        this();//创建空链表,只有头结点
        Node<T> rear = this.head;//rear尾指针指向单链表最后一个结点
        for (int i = 0; i < values.length; i++) {//若长度为0，构造空链表
            if (values[i] != null){
                rear.next = new Node<T>(values[i],null);//尾插入创建结点链入rear结点之后
                rear = rear.next;//rear指向新的尾结点
            }
        }
    }

    //反序单链表
    public void reverse(T[] values){
        for(int i=0; i <values.length; i++)
            this.head.next = new Node<T>(values[i], this.head.next);
    }

    //插入,插入x为第i个元素 x!=null 返回结点。i<0 则头插入,若i>长度尾巴插入
    public Node<T> insert(int i,T x){
        if (x == null)
            return null;
        Node<T> front = this.head;//front指向头结点
        for (int j = 0; front.next != null && j < i; j++)//寻找i-1或最后一个结点(front指向)
            front = front.next;
        front.next = new Node<T>(x,front.next);//在front后插入值为x结点,包括头插入,中间/尾插入
        return front.next;
    }

    //尾插入x
    public Node<T> insert(T x){
        //调用insert 用整数的最大值指定插入在最后
        return insert(Integer.MAX_VALUE,x);
    }

    //删除 删除第i个元素0<=i<长度 返回被删除元素，若越界返回Null
    public T remove(int i){
        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i ; j++)
            front = front.next;
        if (i > 0 && front.next != null){
            T x = front.next.data;
            //删除front的后继,包括头删除,中间和尾删除
            front.next = front.next.next;
            return x;
        }
        return null;
    }

    public Node<T> search(T key){
        //Node<T> front = this.head;
        for(Node<T> p = this.head.next; p != null; p = p.next)
            if (key.equals(p.data))
                return p;
        return null;
    }


    //判断单链表的下一个结点是否为空
    public boolean isEmpty(){
        return this.head.next == null;
    }

    public int size(){
        int count = 0;
        Node<T> p = this.head.next;
        while (p != null){
            p = p.next;
            count++;
        }
        return count;
    }

    //返回第i个元素,0<=i<链表长度,若i越界返回null
    public T get(int i){
        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i ; j++) //遍历单链表 寻找第i个节点
            p = p.next;//用p去指向该节点
        return (i >= 0 && p != null) ? p.data : null;//若p指向第i个节点,则返回元素,如果没有返回null
    }

    @Override
    public String toString() {
        String str = this.getClass().getName()+"(";
        for (Node<T> p = this.head.next; p != null; p = p.next)
            str += p.data.toString()+(p.next != null ? "," : "");
        return str + ")";
    }
}
