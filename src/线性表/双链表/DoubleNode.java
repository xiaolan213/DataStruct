package 线性表.双链表;

public class DoubleNode<T> {
    public T data;
    public DoubleNode<T> prev,next;//前驱,后驱

    public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DoubleNode(T data) {
        this(null,null,null);
    }

    public DoubleNode() {
    }
}
