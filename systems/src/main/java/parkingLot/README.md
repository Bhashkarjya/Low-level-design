# Parking Lot

## Requirements
- Parking lot must support a capacity of 40k vehicles
- Support multiple types of parking spots - compact, large and motocycles
- Allow multiple entrance and exit points
- Support 3 types of vehicles - Cars, Motorcycles and Trucks
- Display board at each entrance and on every floor to show the number of parking spots available for each type of vehicle
- Must not allow vehicles once the parking is full
- Display board should show a "full" message when parking lots are full
- Customers should be issued a parking ticket at entry. This ticket would be used to track parking time and calculate the amount
- Customers should be able to pay at the exit
- System should support configurable pricing rates based on vehicle type and/or parking spot type and rate for different duration
- System should accept different modes of payment (cards/cash)

## Design Patterns
- Singleton - To ensure only a single instance of the ParkingLot is created
- Factory - To create different types of Vehicles and ParkingSpots
- Strategy - To provide the user different modes of payment (cash/card)