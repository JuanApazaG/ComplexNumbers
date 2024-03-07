/**
*Lab 2 Ingenieri de software
* Operaciones sobre numeros complejos
*@author Adalid Flores Gomez
*@version 1.0
*@date 2024-02-29
*/
class HelloWorld {
    public static void main(String[] args) {
        Complex x=new Complex(2,3);
        Complex y=new Complex(-4,3);
        Complex z=new Complex(0,0);
        z=x.adition(y);
        System.out.println("Adition: " + z.toStr());
        z = x.subtraction(y);
        System.out.println("Subtraction: " + z.toStr());
        z = x.multiplication(y);
        System.out.println("Multiplication: " + z.toStr());

        /*parteSergio */
        Complex c1 = new Complex(3, 4);
        Complex logC1 = c1.logarithm();
        System.out.println("Logarithm: " + logC1.toStr());
        System.out.println("toStr: " + c1.toStr());
        String cpxString = "2 + 5i";
        Complex c2 = Complex.toComplex(cpxString);
        System.out.println("toComplex: " + c2.toStr());
    }
}

class Complex{
    int real;
    int img;

    Complex(int r,int i){
        this.real=r;
        this.img=i;
    }
    Complex adition(Complex y){
        Complex z=new Complex(0,0);
        z.real=this.real - y.real;
        z.img=this.img - y.img;
        return (z);
    }
    
    Complex subtraction(Complex y) {
        Complex z = new Complex(0, 0);
        z.real = this.real - y.real;
        z.img = this.img - y.img;
        return z;
    }

    Complex multiplication(Complex y) {
        Complex z = new Complex(0, 0);
        z.real = this.real * y.real - this.img * y.img;
        z.img = this.real * y.img + this.img * y.real;
        return z;
    }
/*parte Sergio
 * logaritmos, convertir complejo a string y viceversa
 */
    Complex logarithm() {
        double r = Math.sqrt(this.real * this.real + this.img * this.img);
        double theta = Math.atan2(this.img, this.real);
        double realPart = Math.log(r);
        double imagPart = theta;
        return new Complex((int) realPart, (int) imagPart);
    }

    String toStr(){
        return (String.valueOf(this.real)) + "+" + String.valueOf(this.img);
        
    }

    static Complex toComplex(String cpx) {
        int realIndex = cpx.indexOf('+');
        int imagIndex = cpx.indexOf('i');
        
        if (realIndex != -1 && imagIndex != -1) {
            String realPart = cpx.substring(1, realIndex).trim();
            String imagPart = cpx.substring(realIndex + 1, imagIndex).trim();
            
            int real = Integer.parseInt(realPart);
            int imag = Integer.parseInt(imagPart);
            
            return new Complex(real, imag);
        } else {
            return null;
        }
    }
}
