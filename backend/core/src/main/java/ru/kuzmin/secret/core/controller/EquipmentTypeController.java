package ru.kuzmin.secret.core.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzmin.secret.core.entity.EquipmentType;

import java.util.List;

@RestController
@RequestMapping("/types")
public class EquipmentTypeController {

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
