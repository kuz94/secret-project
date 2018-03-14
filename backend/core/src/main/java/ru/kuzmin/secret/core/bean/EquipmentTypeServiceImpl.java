package ru.kuzmin.secret.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmin.secret.core.bean.interfaces.EquipmentTypeService;
import ru.kuzmin.secret.core.dao.EquipmentTypeDao;
import ru.kuzmin.secret.core.entity.Category;
import ru.kuzmin.secret.core.entity.Equipment;
import ru.kuzmin.secret.core.entity.EquipmentAttribute;
import ru.kuzmin.secret.core.entity.EquipmentType;

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
    public Optional<EquipmentType> getByCategoty(Category category) {
        return Optional.empty();
    }

    @Override
    public List<EquipmentAttribute> getAttributes(EquipmentType type) {
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
