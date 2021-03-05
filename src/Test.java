import Complex.ComplexADT;

import java.util.Scanner;

public class Test {
    public static void main(String... args) {
        double realPart = 0.0;
        double imagePart = 0.0;
        System.out.println("请输入第一个复数的实部和虚部：");
        Scanner sc = new Scanner(System.in);
        realPart = sc.nextDouble();
        imagePart = sc.nextDouble();
        ComplexADT complexNumber1 = new ComplexADT(realPart, imagePart);

        System.out.println("请输入第二个复数的实部和虚部：");
        realPart = sc.nextDouble();
        imagePart = sc.nextDouble();
        ComplexADT complexNumber2 = new ComplexADT(realPart, imagePart);

        ComplexADT add = complexNumber1.add(complexNumber2);
        ComplexADT sub = complexNumber1.subtract(complexNumber2);
        ComplexADT mul = complexNumber1.multiply(complexNumber2);

        System.out.println("两数相加：" + add.output());
        System.out.println("两数相减：" + sub.output());
        System.out.println("两数相乘：" + mul.output());
    }
}
