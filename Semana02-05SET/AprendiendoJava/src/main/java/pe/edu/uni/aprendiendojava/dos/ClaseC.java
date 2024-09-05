package pe.edu.uni.aprendiendojava.dos;

import pe.edu.uni.aprendiendojava.uno.ClaseA;

public class ClaseC extends ClaseA {
    
    private double  n3 = 45.67;
    private double  n4 = 80.90;

    public void metodoC() {
        //ClaseA o = new ClaseA();
        System.out.println("n1: Sin acceso");
        System.out.println("n2: Sin acceso");
        System.out.println("this.n3: " + this.n3);
        System.out.println("super.n3: " + super.n3);
        System.out.println("this.n4: " + this.n4);
        System.out.println("super.n4: " + super.n4);
    }
}
