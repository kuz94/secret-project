package ru.kuzmin.secret.core.bean.interfaces;

import ru.kuzmin.secret.core.entity.Equipment;
import ru.kuzmin.secret.core.entity.EquipmentType;

import java.util.List;

public interface EquipmentService {

    List<Equipment> getEquipment(EquipmentType type);

    Equipment save(Equipment equipment);

    void delete(Equipment equipment);
}
