package linearlist;

public interface IList {

    //计算长度
    public int size();

    //清空列表
    public void clear();

    //移除元素
    public void remove(int i);

    //添加元素
    public int insert(Object key,int i);

    //获取指定位置上的元素
    public Object get(int i);
}
