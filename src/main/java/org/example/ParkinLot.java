package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.VehicleType.CAR;
import static org.example.VehicleType.TRUCK;

public class ParkinLot {

    int freeCompactSpot;
    int freeBikeSPpot;
    int freeLargeSpot;

    List<CompactSpot> compactSpots = new ArrayList<>();
    List<BikeSpot> bikeSpots = new ArrayList<>();
    List<LargeSpot> largeSpots = new ArrayList<>();

    public ParkinLot(int freeCompactSpot, int freeBikeSPpot, int freeLargeSpot) {
        this.freeCompactSpot = freeCompactSpot;
        this.freeBikeSPpot = freeBikeSPpot;
        this.freeLargeSpot = freeLargeSpot;
    }


    public void parkVehicle(Vehicle vehicle) {
        System.out.print("We are about park : " + vehicle.getVehicleType());
        if (vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
            if (freeLargeSpot > 0) {
                parkYourTruck(vehicle);
            } else {
                System.out.print("Sorry we are full!");
            }
        } else if (vehicle.getVehicleType().equals(VehicleType.BIKE)) {
            if (freeBikeSPpot > 0) {
                parkYourBike(vehicle);
            } else {
                System.out.print("Sorry we are full!");

            }
        } else {
            if (freeCompactSpot > 0) {
                parkYourCar(vehicle);
            } else {
                System.out.print("Sorry we are full!");

            }
        }
    }


    private void parkYourTruck(Vehicle vehicle) {
        LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setFree(false);
        largeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeSpot);
        largeSpots.add(largeSpot);
        System.out.print("parking done");
        freeLargeSpot--;
    }

    private void parkYourBike(Vehicle vehicle) {
        BikeSpot bikeSpot = new BikeSpot(ParkingSpotType.BIKE);
        bikeSpot.setFree(false);
        bikeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(bikeSpot);
        bikeSpots.add(bikeSpot);
        System.out.print("parking done");
        freeBikeSPpot--;
    }

    private void parkYourCar(Vehicle vehicle) {
        CompactSpot compactSpot = new CompactSpot(ParkingSpotType.COMPACT);
        compactSpot.setFree(false);
        compactSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(compactSpot);
        compactSpots.add(compactSpot);
        System.out.print("parking done");
        freeCompactSpot--;
    }

    // UNPARKING THE VEHICLE

    public void unPark(Vehicle vehicle) {
        System.out.print("We are about to UNPARK your vehicle");

        if (vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
            largeSpots.remove(vehicle);
            freeLargeSpot++;
        } else if (vehicle.getVehicleType().equals(VehicleType.BIKE)) {
            compactSpots.remove(vehicle);
            freeCompactSpot++;
        } else {
            bikeSpots.remove(vehicle);
            freeBikeSPpot++;
        }

    }
}
