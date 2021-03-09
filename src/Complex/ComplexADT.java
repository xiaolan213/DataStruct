package Complex;

public class ComplexADT {
    private double realPart;
    private double imagePart;

    public ComplexADT() {
    }

    public ComplexADT(double realPart, double imagePart) {
        this.realPart = realPart;
        this.imagePart = imagePart;
    }

    public double getrealPart() {
        return realPart;
    }

    public void setrealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getimagePart() {
        return imagePart;
    }

    public void setimagePart(double imagePart) {
        this.imagePart = imagePart;
    }

    public ComplexADT add(ComplexADT com){
        judge(com);
        double realPart = this.getrealPart() + com.getrealPart();
        double imagePart = this.getimagePart() + com.getimagePart();
        return new ComplexADT(realPart,imagePart);
    }

    public ComplexADT subtract(ComplexADT com){
        judge(com);
        double realPart = this.getrealPart() - com.getrealPart();
        double imagePart = this.getimagePart() - com.getimagePart();
        return new ComplexADT(realPart,imagePart);
    }

    public ComplexADT multiply(ComplexADT com){
        judge(com);
        //乘法公式(a+bi)(c+di)=(ac-bd)+(bc+ad)i
        double realPart = (this.getrealPart()*com.getrealPart()-this.getimagePart()*com.getimagePart());
        double imagePart = (this.getimagePart()*com.getrealPart()+this.getrealPart()*com.getimagePart());
        return new ComplexADT(realPart,imagePart);
    }

    public ComplexADT conjugate(ComplexADT com){
        judge(com);
        return new ComplexADT(com.getrealPart(),com.imagePart*(-1));
    }

    public ComplexADT judge(ComplexADT com){
        if (com == null)
            return new ComplexADT();
        return com;
    }

    public String output(){
        String symbols = imagePart > 0 ? "+" : "";
        if (imagePart > 0)
            return realPart + symbols + imagePart + "i";
        else if (imagePart < 0)
            return this.realPart + symbols + imagePart + "i";
        else
            return realPart + "";//虚数为0
    }
}
