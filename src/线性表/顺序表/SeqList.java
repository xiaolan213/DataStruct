package 线性表.顺序表;

//顺序表泛型类
public class SeqList<T> extends Object {

    protected Object[] element; //对象数组
    protected int n;            //元素个数(长度)
    private static final int MIN_CAPACITY = 16;

    public SeqList(int length) {
        if (length < MIN_CAPACITY)//如果长度小于最小容量，长度变为最小的容量
            length = MIN_CAPACITY;
        this.element = new Object[length];//存在数组的引用
        this.n = 0;
    }

    //无参构造方法 大小为最小长度
    public SeqList(){
        this(MIN_CAPACITY);
    }

    //由values数组提供元素的构造方法
    public SeqList(T[] values){
        this(values.length * 2);//创建的元素数量因为经常要插入，所以容量设为基础的2倍
        for (int i = 0; i < values.length; i++) //复制非null的数组元素
            if (values[i] != null)
                this.element[this.n++] = values[i];//对象引用赋值
    }

    //获取顺序表的第i个元素
    public T get(int i){
        if (i >= 0 && i < this.n)//返回数组引用的元素,如果没有返回空
            return (T)this.element[i];
        return null;
    }

    //若0<=i<n 且 x!=null 设置第i个元素为x 否则抛出序号越界的异常或空对象异常 O(1)
    public void set(int i,T x){
        if (x == null)  //判断是否为空
            throw new NullPointerException("x==null");//为空抛出异常x为空
        if (i >=0 && i < this.n)//0<=i<x 将第i个元素设置为x
            this.element[i] = x;
        else
            throw new java.lang.IndexOutOfBoundsException(i+"");//下标越界
    }

    public String toString() {
        String str = this.getClass().getName() + "(";   //返回类名
        if (this.n > 0)
            str += this.element[0].toString();  //执行T类的toString()方法
        for (int i = 1; i < this.n; i++)
            str += ", " + this.element[i].toString();
        return str + ")";   //空表返回
    }

    //顺序表的插入
    public int insert(int i, T x){
        if (x == null)
            return -1;
        if (i < 0)
            i = 0;//插入到第一个位置
        if (i > this.n)
            i = this.n;//插入到尾部

        Object source[] = this.element; //数组变量引用赋值,引用element数组
        //数组若是满了，扩充数组的长度
        if (this.n == element.length){
            this.element = new Object[source.length * 2];
            for (int j = 0; j < i; j++)//复制当前数组前的i-1个元素
                this.element[j] = source[j];//复制数组元素，传递数组引用
        }
        //从i开始到表的末尾向后移动元素,次序从后向前
        for (int j = this.n - 1; j >= i; j--)
            this.element[j+1] = source[j];
        this.element[i] = x;
        this.n++;

        return i;
    }

    //尾部插入元素
    public int insert(T x){
        return this.insert(this.n,x);
    }

    //顺序表删除第i个元素
    public T remove(int i){
        //若0<=i<n 返回被删除的元素
        if (i >= 0 && i < this.n){
            T x = (T)this.element[i];//储存被删除的元素
            for (int j = i; j < this.n-1; j++)
                this.element[j] = this.element[j+1];//元素向前移动一个位置
            this.element[this.n-1] = null;//设置元素的对象为空
            this.n--;
            return x;//返回删除的变量x
        }
        //若i越界返回空
        return null;
    }

    //删除所有元素
    public void clear(){
        this.n = 0;//设置长度为0
    }

    //比较this对象与obj是否相等
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj instanceof SeqList<?>){
            SeqList<T> list = (SeqList<T>) obj;
            if (this.n == list.n){
                for (int i = 0; i < this.n; i++) {
                    if (!(this.element[i].equals(list.element[i])))
                        return false;
                    return true;
                }
            }
        }
        return false;
    }

    //表长
    public int size(){
        return this.n;
    }

    //顺序查找
    public int search(T key){
        for (int i = 0; i < this.n; i++)
            if (key.equals(this.element[i]))
                return i;//找到返回下标位置
        return -1;//没找到返回-1
    }

    //对称差集
    public void difference(SeqList<T> seq){
        //循环B的长度
        for (int i = 0; i < seq.n; i++) {
            T str = (T) seq.element[i];//拿出B中此时下标的元素，再在A中寻找
            if (this.search(str) != -1)//寻找到相同元素
                this.remove(this.search(str));//去除A中的相同元素
            else this.insert(str);//如果没找到插入A中
        }
    }

    //判断顺序表是否为空
    public boolean isEmpty(){
        return this.n==0;
    }

//    //深拷贝
//    //复制list所有元素到this,放弃this原数组的元素.O(n)
//    public void copy(SeqList<? extends T> list){
//        this.element = new Object[list.element.length];//申请数组
//    }

}
