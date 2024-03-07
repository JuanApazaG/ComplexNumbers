class HelloWorld {
    public static void main(String[] args) {
        Complex x = new Complex(2, 3);
        Complex y = new Complex(-4, 3);
        Complex z = new Complex(0, 0);
        
        z = x.addition(y);
        System.out.println("Addition: " + z.toString());
        
        z = x.subtraction(y);
        System.out.println("Subtraction: " + z.toString());
        
        z = x.multiplication(y);
        System.out.println("Multiplication: " + z.toString());
        
        z = x.division(y);
        System.out.println("Division: " + z.toString());
        
        Complex conjugateX = x.conjugate();
        Complex conjugateY = y.conjugate();
        
        System.out.println("Conjugate of x: " + conjugateX.toString());
        System.out.println("Conjugate of y: " + conjugateY.toString());
    }
}

class Complex {
    double real;
    double img;

    Complex(double r, double i) {
        this.real = r;
        this.img = i;
    }

    Complex addition(Complex y) {
        Complex z = new Complex(0, 0);
        z.real = this.real + y.real;
        z.img = this.img + y.img;
        return z;
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

    Complex division(Complex y) {
        Complex z = new Complex(0, 0);
        double denominator = y.real * y.real + y.img * y.img;
        z.real = (this.real * y.real + this.img * y.img) / denominator;
        z.img = (this.img * y.real - this.real * y.img) / denominator;
        return z;
    }

    Complex conjugate() {
        return new Complex(this.real, -this.img);
    }

    public String toString() {
        return "(" + this.real + " + " + this.img + "i)";
    }
}
