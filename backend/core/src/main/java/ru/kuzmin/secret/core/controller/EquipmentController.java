package ru.kuzmin.secret.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzmin.secret.core.bean.interfaces.EquipmentService;
import ru.kuzmin.secret.core.entity.Equipment;

import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Equipment> getEquipmentByType(Long typeId, Integer pageSize) {
        return null;
    }

}
