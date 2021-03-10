import complex.ComplexADT;

public class Test {
    public static void main(String... args) {
        //复数ADT
        ComplexADT complexNum1 = new ComplexADT(10, 11);
        ComplexADT complexNum2 = new ComplexADT(2, 20);

        ComplexADT add = complexNum1.add(complexNum2);
        ComplexADT sub = complexNum1.subtract(complexNum2);
        ComplexADT mul = complexNum1.multiply(complexNum2);
        ComplexADT con = complexNum1.conjugate(complexNum2);

        System.out.println("两数相加：" + add.output());
        System.out.println("两数相减：" + sub.output());
        System.out.println("两数相乘：" + mul.output());
        System.out.println("共轭复数: " + con.output());

        //线性表
    }
}
