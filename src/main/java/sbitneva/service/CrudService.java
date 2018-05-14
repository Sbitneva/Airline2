package sbitneva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbitneva.dao.sqlite.AircraftsDao;
import sbitneva.entity.aircrafts.Aircraft;

@Service("crudService")
public class CrudService {

    @Autowired
    private AircraftsDao aircraftsDao;

    public void delete(int id) {
        aircraftsDao.delete(id);
    }

    public void add(Aircraft aircraft) {
        aircraftsDao.create(aircraft);
    }

    public void edit(int id, Aircraft aircraft) {
        aircraftsDao.update(id, aircraft);
    }
}
