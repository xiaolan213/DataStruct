package 线性表.单链表;

//单链表节点类,T泛型返回类型
public class Node<T> {

    public T data;//数据域,存储元素
    public Node<T> next;//地址域,引用下一个节点

    //构造方法为数据域和地址域分配初始数值
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
        this(null,null);
    }

    public String toString() {
        return this.data.toString();
    }
}
