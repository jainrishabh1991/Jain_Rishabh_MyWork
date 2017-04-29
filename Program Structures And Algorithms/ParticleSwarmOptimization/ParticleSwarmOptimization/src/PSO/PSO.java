/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSO;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Rishabh
 */
public class PSO {
    public static ArrayList<ArrayList<Coordinate>> plotData=new ArrayList<>();
    private ArrayList<Sensor> swarm=new ArrayList<>();
    private double[] localBest=new double[Calculation.SWARM_SIZE];
    private ArrayList<Coordinate> localBestCoordinate=new ArrayList<Coordinate>();
    private double globalBest;
    private Coordinate globalBestCoordinate;
    private double[] fitnessValue=new double[Calculation.SWARM_SIZE];
    
    Random rand=new Random();
    
    public void process(){
        initializeSwarm();
        calculateFitnessValues();
        for(int i=0; i<Calculation.SWARM_SIZE; i++) {
			localBest[i] = fitnessValue[i];
			localBestCoordinate.add(swarm.get(i).getCoordinate());
                        ArrayList<Coordinate> abc=new ArrayList<>();
                        plotData.add(abc);
		}
		
		int itr = 0;
		double w;
		double err = 9999;
		
		while(itr < Calculation.MAX_ITERATION && err > Calculation.ERR_TOLERANCE) {
			// step 1 - update pBest
			for(int i=0; i<Calculation.SWARM_SIZE; i++) {
				if(fitnessValue[i] < localBest[i]) {
					localBest[i] = fitnessValue[i];
					localBestCoordinate.set(i, swarm.get(i).getCoordinate());
				}
			}
				
			// step 2 - update gBest
			int bestSensorIndex = Calculation.getMinPos(fitnessValue);
			if(itr == 0 || fitnessValue[bestSensorIndex] < globalBest) {
				globalBest = fitnessValue[bestSensorIndex];
				globalBestCoordinate = swarm.get(bestSensorIndex).getCoordinate();
			}
			
			w = Calculation.W_UPPERBOUND - (((double) itr) / Calculation.MAX_ITERATION) * (Calculation.W_UPPERBOUND - Calculation.W_LOWERBOUND);
			
			for(int i=0; i<Calculation.SWARM_SIZE; i++) {
				double r1 = rand.nextDouble();
				double r2 = rand.nextDouble();
				
				Sensor s = swarm.get(i);
				
				// step 3 - update velocity
				
				double newVel1 = (w * s.getVelocity().getLowerVelocity()) + 
							(r1 * Calculation.C1) * (localBestCoordinate.get(i).getxCoordinate() - s.getCoordinate().getxCoordinate()) +
							(r2 * Calculation.C2) * (globalBestCoordinate.getxCoordinate() - s.getCoordinate().getxCoordinate());
				double newVel2 = (w * s.getVelocity().getLowerVelocity()) + 
							(r1 * Calculation.C1) * (localBestCoordinate.get(i).getyCoordinate() - s.getCoordinate().getyCoordinate()) +
							(r2 * Calculation.C2) * (globalBestCoordinate.getyCoordinate() - s.getCoordinate().getyCoordinate());
                                
                                Velocity vel = new Velocity();
                                vel.setLowerVelocity(newVel1);
                                vel.setUpperVelocity(newVel2);
				s.setVelocity(vel);
				
				// step 4 - update location
                                
                                Coordinate coordinate=new Coordinate();
                                coordinate.setxCoordinate(s.getCoordinate().getxCoordinate()+newVel1);
                                coordinate.setyCoordinate(s.getCoordinate().getyCoordinate()+newVel2);        
                                        
				s.setCoordinate(coordinate);
                                
                                plotData.get(i).add(coordinate);
			}
			
			err = Calculation.calculate(globalBestCoordinate); // minimizing the functions means it's getting closer to 0
			
			
			System.out.println("---At Iteration " + itr + ": ");
			System.out.println("X Coordinate of Global Best  : " + globalBestCoordinate.getxCoordinate());
			System.out.println("Y Coordinate of Global Best  : " + globalBestCoordinate.getyCoordinate());
			System.out.println("Fitness Value of Global Best : " + Calculation.calculate(globalBestCoordinate));
			
			itr++;
			calculateFitnessValues();
		}
		
                System.out.println("------------------------------------");
		System.out.println("\nSolution found at iteration " + (itr - 1) + ", the solutions is:");
		System.out.println("Coordinate X: " + globalBestCoordinate.getxCoordinate());
		System.out.println("Coordinate Y: " + globalBestCoordinate.getyCoordinate());
        
    }
    public void initializeSwarm(){
        Sensor s;
		for(int i=0; i<Calculation.SWARM_SIZE; i++) {
			s = new Sensor();
			
			// randomize location inside a space defined in Problem Set
			Coordinate coordinate = new Coordinate();
			coordinate.setxCoordinate(Calculation.X_LOW + rand.nextDouble() * (Calculation.X_HIGH - Calculation.X_LOW));
			coordinate.setyCoordinate(Calculation.Y_LOW + rand.nextDouble() * (Calculation.Y_HIGH - Calculation.Y_LOW));
			
			
			// randomize velocity in the range defined in Problem Set
			
                        Velocity velocity=new Velocity();
                        velocity.setLowerVelocity(Calculation.VEL_LOW + rand.nextDouble() * (Calculation.VEL_HIGH - Calculation.VEL_LOW));
			velocity.setUpperVelocity(Calculation.VEL_LOW + rand.nextDouble() * (Calculation.VEL_HIGH - Calculation.VEL_LOW));
                        
                        s.setCoordinate(coordinate);
                        s.setVelocity(velocity);
			
			swarm.add(s);
		}
    }
    
    public void calculateFitnessValues(){
        for(int i=0; i<Calculation.SWARM_SIZE; i++) {
			fitnessValue[i] = swarm.get(i).getFitnessValue();
		}
    }
}
