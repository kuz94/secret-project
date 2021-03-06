package ru.kuzmin.rent.equipment.services.interfaces;

import ru.kuzmin.rent.equipment.entities.Category;
import ru.kuzmin.rent.equipment.entities.EquipmentAttribute;
import ru.kuzmin.rent.equipment.entities.EquipmentType;

import java.util.List;
import java.util.Optional;

public interface EquipmentTypeService {

    EquipmentType saveType(EquipmentType type);

    void deleteType(EquipmentType type);

    Optional<EquipmentType> loadByCategoty(Category category);

    List<EquipmentAttribute> loadAttributes(EquipmentType type);

    void addAttributes(List<EquipmentAttribute> attributes);

    void deleteAttributes(List<EquipmentAttribute> attributes);

    void addAttribute(EquipmentAttribute equipmentAttribute);

    void deleteAttribute(EquipmentAttribute equipmentAttribute);

}
