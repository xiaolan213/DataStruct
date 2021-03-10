import linearlist.SeqList;

public class Test {
    public static void main(String... args) {

        /**
         * //复数ADT
         *ComplexADT complexNum1 = new ComplexADT(10, 11);
         *ComplexADT complexNum2 = new ComplexADT(2, 20);
         *
         *ComplexADT add = complexNum1.add(complexNum2);
         *ComplexADT sub = complexNum1.subtract(complexNum2);
         *ComplexADT mul = complexNum1.multiply(complexNum2);
         *ComplexADT con = complexNum1.conjugate(complexNum2);
         *
         *System.out.println("两数相加：" + add.output());
         *System.out.println("两数相减：" + sub.output());
         *System.out.println("两数相乘：" + mul.output());
         *System.out.println("共轭复数: " + con.output());
         */


        //顺序表
        String val[] = {"a", "b", "c", "d", "e"};
        String val2[] = {"a", "b", "c"};

        SeqList<String> lista = new SeqList<String>(val);//引用顺序表的实例

        SeqList<String> listc = new SeqList<String>(val2);

        System.out.println("表的长度"+lista.size()
                + "\n创建表:"+lista.toString());
        lista.insert("abc");
        System.out.println("表的插入(插入abc元素):"+lista.toString());
        lista.remove(5);
        System.out.println("表的删除(删除第五个abc元素):"+lista.toString());
        System.out.println("返回a的下标"+lista.search("a"));
        System.out.println("查找第0个元素"+lista.get(0));
        System.out.println(lista.toString()
                +"与"+listc.toString()
                +"的并差集"
        );
        lista.difference(listc);
        System.out.println(lista.toString());
    }

}
