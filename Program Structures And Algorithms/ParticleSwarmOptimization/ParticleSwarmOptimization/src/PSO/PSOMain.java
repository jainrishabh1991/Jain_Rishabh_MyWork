/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSO;


import java.util.Random;

/**
 *
 * @author Rishabh
 */
public class PSOMain {

    public static double[][] domain = new double[10][10];
    
    public void display(double[][] region) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(region[i][j]+" | ");
            }
            System.out.println();
        }

    }
    public static int randomTemp(int min, int max) {
        Random rand = new Random();
        int temperature = rand.nextInt((max - min) + 1) + min;
        return temperature;
    }
    
     public static double[][] getRegion() {

        double[][] region = new double[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                region[i][j] = randomTemp(10, 45);
            }
        }
        return region;
    }

    public static void main(String args[]) {
        
        
        domain=getRegion();
        
        System.out.println("Region With Temperature");
        PSOMain pmain=new PSOMain();
        pmain.display(domain);
        
        System.out.println("---Maximum Temperature Recorded At---");
        System.out.println("X - Coordinate:-"+Calculation.xTarget);
        System.out.println("Y - Coordinate:-"+Calculation.yTarget);
        System.out.println("------------------------------------");
        PSO p = new PSO();
        p.process();
        JavaFXApplication j = new JavaFXApplication();
        j.visual(args);
    }
}
