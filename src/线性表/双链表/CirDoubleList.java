package 线性表.双链表;

//循环双链表类
public class CirDoubleList<T> {

    public DoubleNode<T> head;//头指针

    public CirDoubleList() {
        this.head = new DoubleNode<T>();//创建头结点，3个域值均为null
        this.head.prev = this.head;
        this.head.next = this.head;
    }

    //判断是否为空
    public boolean isEmpty(){
        return this.head.next == this.head;//判断是否为空
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
        for (int j = 0; p != this.head ; j++)//先遍历一遍 找到尾结点
            p = p.next;
        if (p == head){ //第一个双链表遍历完毕
            DoubleNode<T> rear = this.head.prev; //创建rear结点指向尾结点 == 头结点前指针指向的位置
            rear.next = list.head.next; //尾结点的下一指针指向需要合并列表的头指针的next位置
            list.head.prev.next = this.head;//合并列表的头指针=>尾巴指回的位置的next结点与第一个链表连接
            list.head.next.prev = rear;//新链表的下一个结点的头指针与第一个链表的尾指针的位置相连
            this.head.prev = list.head.prev;//头尾指针连接构成循环
        }
    }

    //循环双链表的深拷贝
    public void copy(CirDoubleList<T> list){
        DoubleNode<T> p = list.head.next;//拿到需要复制的第一个元素
        DoubleNode<T> rear = this.head;//将rear指向当前链表的头部
        while (p != list.head){
            rear.prev.next = rear;
            rear.next = new DoubleNode<T>(p.data,rear,this.head);//深拷贝
            rear = rear.next;
            p = p.next;
        }
        rear.prev.next = rear;//当前链表的头尾连接构成循环
    }

    @Override
    public String toString() {
        String str = this.getClass().getName()+"(";
        for (DoubleNode<T> p = this.head.next; p != this.head; p = p.next)
            str += p.data.toString()+(p.next != this.head ? "," : "");
        return str + ")";
    }
}
