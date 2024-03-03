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

    String toStr(){
        return (String.valueOf(this.real)) + "+" + String.valueOf(this.img);
        
    }
}
