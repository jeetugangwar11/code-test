package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GENx extends Engine{
    private static final Logger logger = LogManager.getLogger(GENx.class);

    private static final String ENGINE_MODEL = GENx.class.getSimpleName();
    private final String serialNumber;
    private double flightHours;
    private int numRebuilds;

    public GENx(String serialNumber, double flightHours, int numRebuilds) {
    	super(4, 20_000, 13_552, 14_103, 74_170);
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    public GENx(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GENx(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public double getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(double flightHours) {
        this.flightHours = flightHours;
    }

    public double thrustToWeightRatio() {
        return takeoffThrust / dryWeight;
    }

    public double getFlightHoursBeforeRebuild(){
    	return flightHoursBeforeRebuild-flightHours;
    }
    
    public double serviceLifeLeft(){
    	return ((maxNumRebuilds - numRebuilds)*flightHoursBeforeRebuild)-flightHours;
    }
    public String toString() {
        return ENGINE_MODEL + " SN: " + serialNumber;
    }

}
