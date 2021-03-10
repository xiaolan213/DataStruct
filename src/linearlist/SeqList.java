package linearlist;

//顺序表泛型类
public class SeqList<T> {

    protected Object[] element; //对象数组
    protected int n;            //元素个数(长度)
    private static final int MIN_CAPACITY = 16;

    public SeqList(int length) {
        if (length < MIN_CAPACITY)//如果长度小于最小容量，长度变为最小的容量
            length = MIN_CAPACITY;
        this.element = new Object[length];//存在数组的引用
        this.n = 0;
    }

    public SeqList(){
        this(MIN_CAPACITY);
    }

    //由values数组提供元素
    public SeqList(T[] values){
        this(values.length * 2);//创建的元素数量因为经常要插入，所以容量设为基础的2倍
        for (int i = 0; i < values.length; i++) //复制非null的数组元素
            if (values[i] != null)
                this.element[this.n++] = values[i];//对象引用赋值
    }

    //判断顺序表是否为空
    public boolean isEmpty(){
        return this.n==0;
    }

    //返回元素个数
    public int size(){
        return element.length;
    }

}
