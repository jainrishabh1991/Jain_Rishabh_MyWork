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
public class Calculation {

    public static final double X_LOW = 1;
    public static final double X_HIGH = 200;
    public static final double Y_LOW = 1;
    public static final double Y_HIGH = 200;
    public static final double VEL_LOW = -1;
    public static final double VEL_HIGH = 1;
    public static final int SWARM_SIZE = 30;
    public static final int MAX_ITERATION = 100;
    public static final int PROBLEM_DIMENSION = 2;
    public static final double C1 = 2.0;
    public static final double C2 = 2.0;
    public static final double W_UPPERBOUND = 1.0;
    public static final double W_LOWERBOUND = 0.0;
    public static final double ERR_TOLERANCE = 1E-20; // the smaller the tolerance, the more accurate the result, 
    // but the number of iteration is increased
    static double xTarget = getMaxPos(PSOMain.domain).getxCoordinate();
    static double yTarget = getMaxPos(PSOMain.domain).getyCoordinate();

    public static double calculate(Coordinate coordinate) {
        double result = 0;
        double x = coordinate.getxCoordinate(); // the "x" part of the location
        double y = coordinate.getyCoordinate(); // the "y" part of the location

        result = Math.sqrt((xTarget - x) * (xTarget - x) + (yTarget - y) * (yTarget - y));

        return result;
    }

    public static int getMinPos(double[] list) {
        int pos = 0;
        double minValue = list[0];

        for (int i = 0; i < list.length; i++) {
            if (list[i] < minValue) {
                pos = i;
                minValue = list[i];
            }
        }

        return pos;
    }


    public static Coordinate getMaxPos(double[][] list) {

        double x = 0;
        double y = 0;
        double max = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i][j] > max) {
                    max = list[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        Coordinate result = new Coordinate();
        result.setxCoordinate(x);
        result.setyCoordinate(y);
        return result;
    }

}
