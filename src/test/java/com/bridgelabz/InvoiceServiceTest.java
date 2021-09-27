package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;

    @BeforeEach
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(25, fare);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 1.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(15, fare);
    }

    @Test
    public void givenLessDistanceAndLessTime_ShouldReturnTotalFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(5, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary actualSummary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualSummary);
    }

    @Test
    public void givenUserIDAndRideList_ShouldReturnInvoiceSummary() {
        String userId = "sakshi.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualSummary);
    }
}

