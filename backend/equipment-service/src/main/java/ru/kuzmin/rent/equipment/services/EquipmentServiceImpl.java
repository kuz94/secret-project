package ru.kuzmin.rent.equipment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmin.rent.equipment.services.interfaces.EquipmentService;
import ru.kuzmin.rent.equipment.entities.Equipment;
import ru.kuzmin.rent.equipment.dao.EquipmentDao;
import ru.kuzmin.rent.equipment.entities.EquipmentType;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentDao equipmentDao;

    @Autowired
    public EquipmentServiceImpl(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    @Override
    public List<Equipment> getEquipment(EquipmentType type) {
        return null;
    }

    @Override
    public Equipment save(Equipment equipment) {
        return null;
    }

    @Override
    public void delete(Equipment equipment) {

    }
}
