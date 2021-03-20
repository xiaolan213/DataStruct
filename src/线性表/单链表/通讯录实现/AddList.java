package 线性表.单链表.通讯录实现;

//通讯录类
public class AddList{

    private String name;//姓名
    private int mobile_num;//电话号码
    private String address;//地址

    public AddList(String name, int mobile_num, String address) {
        this.name = name;
        this.mobile_num = mobile_num;
        this.address = address;
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

}
