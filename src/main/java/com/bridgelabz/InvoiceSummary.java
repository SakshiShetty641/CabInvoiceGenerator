package com.bridgelabz;

public class InvoiceSummary {
    private final int noOfRides;
    private final double totalFair;
    private final double averageFair;

    public InvoiceSummary(int noOfRides, double totalFair) {
        this.noOfRides = noOfRides;
        this.totalFair = totalFair;
        this.averageFair = this.totalFair/this.noOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return noOfRides == that.noOfRides &&
                Double.compare(that.totalFair, totalFair) == 0 &&
                Double.compare(that.averageFair, averageFair) == 0;
    }
}
