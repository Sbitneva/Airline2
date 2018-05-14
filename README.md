[![Build Status](https://travis-ci.org/Sbitneva/Airline2.svg?branch=dev)](https://travis-ci.org/Sbitneva/Airline2)

# GL Final Task

## Airline

### Initial tasks
1. Define aircraft class hierarchy. There should be 3 levels of the hierarchy.
1. Create an airline company that stores airplanes.
1. Calculate total capacity and carrying capacity of all the aircraft in the airline.
1. Sort the aircrafts by flight range (from smaller to larger) and display it on screen.
1. Find aircraft corresponding to the specified range of fuel consumption parameters (liters per hour).
1. Console menu should contain following commands at bare minimum:
    - Calculate the total capacity and carrying capacity of all the aircraft in the airline.
    - Display the list of aircraft of the company sorted by flight range.
    - Find airplanes corresponding to a given range of fuel consumption parameters.

### Final tasks
1. Develop application with Spring Core and REST WS.
1. Use any DB. 
1. Unit test coverage more then 65%.
1. Make RESTful web services:
    - Add, edit, delete a aircraft.
    - Get calculated total passenger capacity and cargo capacity of all the
aircrafts in the airline.
    - Get sorted list of all aircrafts in the airline. Sort the aircrafts by flight range (from smaller to larger).
    - Find aircraft corresponding to the specified range of fuel consumption parameters (liters per hour).
    - Find aircraft which corresponding to the specified passenger capacity and the flight range.

## Requirements

- Linux Ubuntu 16.04
- git
- OpenJDK 8 (JRE)
- maven

## Build

1. Clone the project
    ```bash
    git clone https://www.github.com/Sbitneva/Airline2
    ```

2. Change directory
    ```bash
    cd Airline2
    ```

3. Run clean and default lifecycles (inclusive up to install phase)
    ```bash
    mvn clean install
    ```

## Run service

```bash
java -jar target/airline-1.0-SNAPSHOT.jar
```

Requests can be checked, for example, within the browser at URI `http://locahost:8080/...`

## REST API requests examples

- Show all aircrafts in airline
    ```
    http://localhost:8080/airline/showAll
    ```
- Delete aircraft
    ```
    http://localhost:8080/airline/delete?id=2
    ```
- Edit aircraft
    ```
    http://localhost:8080/airline/edit?id=1&name=Kolyan&flightRange=0&fuelConsumption=0
    ```
- Add aircraft
    ```
    http://localhost:8080/airline/add_aircraft?name=911&type_id=2&flightRange=8000&fuelConsumption=10000
    ```
- Calculate total passenger capacity and cargo capacity of all the
aircrafts in the airline
    ```
    http://localhost:8080/airline/totalCapacity
    ```
- Get sorted list of all aircrafts in the airline. Sort the aircrafts by flight
range (from smaller to larger)
    ```
    http://localhost:8080/airline/sort/flightRange
    ```
- Find aircraft corresponding to the specified range of fuel consumption
parameters (liters per hour)
    ```
    http://localhost:8080/airline/fuelRange?minRange=4000&maxRange=5000
    ```
- Find aircraft which corresponding to the specified passenger capacity
and the flight range
    ```
    http://localhost:8080/airline/find?capacity=1000&flightRange=6000
    ```
