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
        System.out.println("Suma: " + z.toStr());
        z = x.subtraction(y);
        System.out.println("Resta: " + z.toStr());
        z = x.multiplication(y);
        System.out.println("Multiplicacion: " + z.toStr());

        double modulo = x.modulo();
        System.out.println("Modulo: " + modulo);
        double argumento = x.argumento();
        System.out.println("Fase o argumento: " + argumento);

        z = x.power(5);
        System.out.println("Potencia:" + z.toStr());
        z = x.squareRoot(y,x);
        System.out.println("Raiz Cuadrada:" + z.toStr());


    }
}

class Complex {
    int real;
    int img;
    Complex(int r, int i) {
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

    double modulo(){
        return Math.sqrt(this.real*this.real + this.img*this.img);
    }

    double argumento(){
        return Math.atan(this.img / this.real);
    }

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

    String toStr() {
        return (String.valueOf(this.real)) + "+" + String.valueOf(this.img) + "i";
    }
}
