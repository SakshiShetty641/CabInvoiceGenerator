package com.bridgelabz;

/**
 * Purpose - To simulate a Gab Invoice Generator
 * @author - Sakshi Shetty
 * @version - 8.0
 * @since - 2021-09-25
 */

public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_TIME = 1;

    public double calculateFare(double distance, int time) {
        return distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
    }
}