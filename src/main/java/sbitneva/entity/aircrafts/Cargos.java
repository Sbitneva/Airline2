package sbitneva.entity.aircrafts;

import sbitneva.entity.aircrafts.internal.Cargo;

import java.util.ArrayList;

public interface Cargos {

    void addCargo(Cargo cargo);

    ArrayList<Cargo> getCargos();

    void setCargos(ArrayList<Cargo> cargos);
}
