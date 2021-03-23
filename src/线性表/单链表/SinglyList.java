package 线性表.单链表;

//单链表类 继承object,并重写comparable接口
public class SinglyList<T extends Comparable<? super T>> extends Object {

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

    //通过名字查找
    public Node<T> search(T key){
        for(Node<T> p = this.head.next; p != null; p = p.next)
            if (key.compareTo(p.data) == 0)
                return p;
        return null;
    }

    //反序单链表
    public void reverse(){
        //判断链表的结点是否存在2个及以上
        if (head == null || head.next == null)
            return;
        Node<T> temp = head.next;//临时结点
        Node<T> next = null;
        Node<T> pre = null;
        while (temp.next != null) {
            next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        temp.next = pre;
        this.head.next = temp;
    }



//    //逆置
//    public void reverse() {
//        if (isEmpty()){
//            return;
//        }
//        reverse(head.next);
//    }
//    //反转指定的curr，并将反转后的结点返回
//    public Node reverse(Node curr){
//        if (curr.next == null){
//            head.next = curr;
//            return curr;
//        }
//        //递归的反转当前的结点的下一个结点。返回值就是链表反转后的当前结点的上一个结点
//        Node pre = reverse(curr.next);
//        //让返回的下一个结点b变为当前结点
//        pre.next = curr;
//        //把当前结点的下一个结点变为null
//        curr.next = null;
//        return curr;
//    }



    //插入,插入x为第i个元素 x!=null 返回结点。i<0 则头插入,若i>长度尾巴插入
    public Node<T> insert(int i,T x){
        if (x == null)
            return null;
        Node<T> front = this.head;//front指向头结点
        for (int j = 0; front.next != null && j < i; j++){
            //寻找i-1或最后一个结点(front指向)
                front = front.next;
        }
        front.next = new Node<T>(x,front.next);//在front后插入值为x结点,包括头插入,中间/尾插入
        return front.next;
    }

    //排序插入
    public Node<T> insert(T x){
        //调用insert 用整数的最大值指定插入在最后
        for (Node<T> i = this.head; i.next != null ; i = i.next){
            if (i.next != null){
                if (x.compareTo(i.next.data) <= 0){
                    i.next = new Node<T>(x,i.next);
                    return i.next;
                }
            }
        }
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
