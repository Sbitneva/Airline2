package sbitneva.entity.aircrafts;

import sbitneva.entity.aircrafts.internal.Cargo;

import java.util.ArrayList;

public class CargosAirplane extends Airplane implements Cargos {

    private ArrayList<Cargo> cargosList = new ArrayList<>();

    public CargosAirplane() {
        super();
    }

    public CargosAirplane(int id, int typeId, String name, int capacity, int flightRange, int fuelConsumption, int carriageCapacity) {
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

}
