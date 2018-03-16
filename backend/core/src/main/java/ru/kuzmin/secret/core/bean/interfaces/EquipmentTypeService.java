package ru.kuzmin.secret.core.bean.interfaces;

import ru.kuzmin.secret.core.entity.Category;
import ru.kuzmin.secret.core.entity.Equipment;
import ru.kuzmin.secret.core.entity.EquipmentAttribute;
import ru.kuzmin.secret.core.entity.EquipmentType;

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
