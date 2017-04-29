/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSO;

/**
 *
 * @author Rishabh
 */
public class Sensor {
        private double fitnessValue;
	private Velocity velocity;
	private Coordinate coordinate;
	
	public Sensor() {
		super();
	}

	public Sensor(double fitnessValue, Velocity velocity, Coordinate coordinate) {
		super();
		this.fitnessValue = fitnessValue;
		this.velocity = velocity;
		this.coordinate = coordinate;
	}

	public Velocity getVelocity() {
		return velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public double getFitnessValue() {
		fitnessValue = Calculation.calculate(coordinate);
		return fitnessValue;
	}
}
