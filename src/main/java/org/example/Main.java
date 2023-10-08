package org.example;

public class Main {
    public static void main(String[] args) {
        ParkinLot parkinLot = new ParkinLot(10,10,10);
        Vehicle truck = new Vehicle(VehicleType.TRUCK);
       // parkinLot.parkVehicle(truck);
        parkinLot.unPark(truck);

    }
}