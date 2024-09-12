package pe.edu.uni.poosemana03.service;

import java.util.Arrays;

public class MateService {

    public int calcPromedio(int n1, int n2) {
        return (n1 + n2) / 2;
    }

    public int calcPromedio(int n1, int n2, int n3) {
        return (n1 + n2 + n3) / 3;
    }
    
     public int calcPromedio(int... notas) {
        return (int) Arrays.stream(notas).average().orElse(0.0);
        /*
         
        int suma=0 ;
        for (int nota : notas) {
             suma+=nota;
        }
        int pr=suma/notas.length;       
        return pr;
        */
    }

}
