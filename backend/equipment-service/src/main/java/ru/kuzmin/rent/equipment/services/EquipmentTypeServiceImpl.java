package ru.kuzmin.rent.equipment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmin.rent.equipment.services.interfaces.EquipmentTypeService;
import ru.kuzmin.rent.equipment.dao.EquipmentTypeDao;
import ru.kuzmin.rent.equipment.entities.Category;
import ru.kuzmin.rent.equipment.entities.EquipmentAttribute;
import ru.kuzmin.rent.equipment.entities.EquipmentType;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    private final EquipmentTypeDao equipmentTypeDao;

    @Autowired
    public EquipmentTypeServiceImpl(EquipmentTypeDao equipmentTypeDao) {
        this.equipmentTypeDao = equipmentTypeDao;
    }

    @Override
    public EquipmentType saveType(EquipmentType type) {
        return null;
    }

    @Override
    public void deleteType(EquipmentType type) {

    }

    @Override
    public Optional<EquipmentType> loadByCategoty(Category category) {
        return Optional.empty();
    }

    @Override
    public List<EquipmentAttribute> loadAttributes(EquipmentType type) {
        return null;
    }

    @Override
    public void addAttributes(List<EquipmentAttribute> attributes) {

    }

    @Override
    public void deleteAttributes(List<EquipmentAttribute> attributes) {

    }

    @Override
    public void addAttribute(EquipmentAttribute equipmentAttribute) {

    }

    @Override
    public void deleteAttribute(EquipmentAttribute equipmentAttribute) {

    }
}
