package ru.kuzmin.secret.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzmin.secret.core.entity.Equipment;

import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Equipment> getEquipmentByType(Long typeId, Integer pageSize) {
        return null;
    }


}
