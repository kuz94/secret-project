package ru.kuzmin.secret.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmin.secret.core.bean.interfaces.EquipmentService;
import ru.kuzmin.secret.core.dao.EquipmentDao;
import ru.kuzmin.secret.core.entity.Equipment;
import ru.kuzmin.secret.core.entity.EquipmentType;

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
