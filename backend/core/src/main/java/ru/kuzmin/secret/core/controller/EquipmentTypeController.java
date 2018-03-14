package ru.kuzmin.secret.core.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzmin.secret.core.bean.interfaces.EquipmentTypeService;
import ru.kuzmin.secret.core.entity.EquipmentType;

import java.util.List;

@RestController
@RequestMapping("/types")
public class EquipmentTypeController {

    private final EquipmentTypeService equipmentTypeService;

    @Autowired
    public EquipmentTypeController(EquipmentTypeService equipmentTypeService) {
        this.equipmentTypeService = equipmentTypeService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createType(EquipmentType type) {

    }

    public void removeType() {

    }

    public void updateType() {

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<EquipmentType> get() {
        return null;
    }
}
