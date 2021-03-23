package 线性表.单链表.通讯录实现;

//通讯录类
public class AddList implements Comparable<AddList> {

    private String name;//姓名
    private int mobile_num;//电话号码
    private String address;//地址

    public AddList(String name, int mobile_num, String address) {
        this.name = name;
        this.mobile_num = mobile_num;
        this.address = address;
    }

    public AddList(String name) {
        this.name = name;
    }

    public AddList() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(int mobile_num) {
        this.mobile_num = mobile_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "姓名:"+name+" 地址:"+address+" 手机号:"+mobile_num;
    }

    @Override
    public int compareTo(AddList o) {
        return this.getName().compareTo(o.getName());
    }
}
