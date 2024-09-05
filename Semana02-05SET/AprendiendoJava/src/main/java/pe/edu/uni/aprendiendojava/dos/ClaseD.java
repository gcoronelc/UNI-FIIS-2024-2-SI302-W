package pe.edu.uni.aprendiendojava.dos;

import pe.edu.uni.aprendiendojava.uno.ClaseA;

public class ClaseD {
   
    public void metodoD() {
        ClaseA o = new ClaseA();
        System.out.println("n1: Sin acceso");
        System.out.println("n2: Sin acceso");
        System.out.println("n3: Sin acceso");
        System.out.println("n4: " + o.n4);
    }
}
