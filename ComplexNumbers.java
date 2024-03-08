/**
 * Ingenieria de software
 * Operaciones sobre numeros complejos
 * 
 * @author Apaza Guzman Juan Agustin
 * @author Flores Gomez Adalid
 * @author Huarachi Navarro Sergio Alejandro
 * @author Jancko Gallardo Pablo Alejandro
 * @version 1.0
 * @date 2024-03-08
 */

 class ComplexNumbers {
    public static void main(String[] args) {
        Complex x = new Complex(2, 3);
        Complex y = new Complex(-4, 3);
        Complex z = new Complex(0, 0);
        z = x.adition(y);
        System.out.println("Suma: " + z.toString());
        z = x.subtraction(y);
        System.out.println("Resta: " + z.toString());
        z = x.multiplication(y);
        System.out.println("Multiplicacion: " + z.toString());

        /*Parte Agustin */
        z = x.division(y);
        System.out.println("Division: " + z.toString());
        
        Complex conjugateX = x.conjugate();
        Complex conjugateY = y.conjugate();
        
        System.out.println("Conjugate of x: " + conjugateX.toString());
        System.out.println("Conjugate of y: " + conjugateY.toString());

        /*Parte Jancko */
        double modulo = x.modulo();
        System.out.println("Modulo: " + modulo);
        double argumento = x.argumento();
        System.out.println("Fase o argumento: " + argumento);

        /*Parte Adalid */
        z = x.power(5);
        System.out.println("Potencia:" + z.toString());
        z = x.squareRoot(y,x);
        System.out.println("Raiz Cuadrada:" + z.toString());

        /*Parte Sergio */
        Complex c1 = new Complex(3, 4);
        Complex logC1 = c1.logarithm();
        System.out.println("Logarithm: " + logC1.toString());

    }
}

class Complex {
    double real;
    double img;

    Complex(double r, double i) {
        this.real = r;
        this.img = i;
    }

    //Suma
    Complex adition(Complex y) {
        Complex z = new Complex(0, 0);
        z.real = this.real + y.real;
        z.img = this.img + y.img;
        return (z);
    }
    //Resta
    Complex subtraction(Complex y) {
        Complex z = new Complex(0, 0);
        z.real = this.real - y.real;
        z.img = this.img - y.img;
        return z;
    }

    //Multiplicacion
    Complex multiplication(Complex y) {
        Complex z = new Complex(0, 0);
        z.real = this.real * y.real - this.img * y.img;
        z.img = this.real * y.img + this.img * y.real;
        return z;
    }

    /*Parte Agustin*/
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

    /*Parte Jancko*/
    double modulo(){
        return Math.sqrt(this.real*this.real + this.img*this.img);
    }

    double argumento(){
        return Math.atan(this.img / this.real);
    }

    /*Parte Adalid */
    Complex power(int n) {
        double newReal = modulo() * Math.cos(n * argumento());
        double newImg = modulo() * Math.sin(n * argumento());
        Complex z = new Complex((int) newReal, (int) newImg);
        return z;
    }

    Complex squareRoot(Complex y,Complex x){
        int Imaginario;
        if (this.img==0) {
            Imaginario=0;
        }else{
            if (y.img>1) {
                Imaginario=1;
            }else{
                Imaginario=-1;
            }
        }
        double Realsquare=Math.sqrt((modulo()+this.real)/2);
        double Imgsquare=(((Imaginario)*Math.sqrt(modulo()-x.img))/(Math.sqrt(2)));
        Complex z = new Complex((int) Realsquare,(int) Imgsquare);
        return z;

    }

    /*Parte Sergio */
    Complex logarithm() {
    double r = Math.sqrt(this.real * this.real + this.img * this.img);
    double theta = Math.atan2(this.img, this.real);
    double realPart = Math.log(r);
    double imagPart = theta;
    return new Complex((int) realPart, (int) imagPart);
    }

    public String toString() {
        return "(" + this.real + " + " + this.img + "i)";
    }
}