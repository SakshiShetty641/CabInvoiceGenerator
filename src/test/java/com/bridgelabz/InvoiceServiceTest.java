package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    Ride[] rides = null;
    InvoiceService invoiceService = null;
    InvoiceSummary expectedInvoiceSummary = null;
    RideRepository rideRepository = null;

    @BeforeEach
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
        rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[]{
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
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
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)
        };
        InvoiceSummary actualSummary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualSummary);
    }

    @Test
    public void givenUserIDAndRideList_ShouldReturnInvoiceSummary() {
        String userId = "sakshi.com";
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualSummary);
    }

    @Test
    public void givenUserIDAndMultipleRideList_ShouldReturnInvoiceSummary() {
        String userId = "sakshi.com";
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualSummary);
    }

    @Test
    void givenDistanceAndTime_WhenCalculatedForPremiumRide_ShouldReturnInvoiceSummary() {
        String userId = "sakshi.com";
        Ride [] rides = new Ride[]{new Ride(CabRide.PREMIUM, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1),
                new Ride(CabRide.PREMIUM, 1.0, 5),
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 85.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualSummary);
    }
}

