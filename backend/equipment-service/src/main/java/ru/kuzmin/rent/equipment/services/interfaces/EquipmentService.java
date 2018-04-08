package ru.kuzmin.rent.equipment.services.interfaces;

import ru.kuzmin.rent.equipment.entities.Equipment;
import ru.kuzmin.rent.equipment.entities.EquipmentType;

import java.util.List;

public interface EquipmentService {

    List<Equipment> getEquipment(EquipmentType type);

    Equipment save(Equipment equipment);

    void delete(Equipment equipment);
}
