package sbitneva.entity.aircrafts;

import sbitneva.entity.aircrafts.internal.Cargo;

import java.util.ArrayList;

public class CargosHelicopter extends Helicopter implements Cargos {

    private ArrayList<Cargo> cargosList = new ArrayList<>();

    public CargosHelicopter() {

    }

    public CargosHelicopter(int id, int typeId, String name, int capacity, int flightRange, int fuelConsumption, int carriageCapacity) {
        super(id, typeId, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }

    public void addCargo(Cargo cargo) {
        cargosList.add(cargo);
    }

    @Override
    public ArrayList<Cargo> getCargos() {
        return this.cargosList;
    }

    @Override
    public void setCargos(ArrayList<Cargo> cargos) {
        this.cargosList = cargos;
    }

    @Override
    public int getCapacity() {
        int carriageCapacity = 0;
        for (Cargo cargo : cargosList) {
            carriageCapacity += cargo.getWeight();
        }
        this.setCarriageCapacity(carriageCapacity);
        return carriageCapacity;
    }


}
