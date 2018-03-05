package ru.kuzmin.secret.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @RequestMapping()
    public void create() {

    }

    @RequestMapping
    public void createNested() {

    }

    @RequestMapping
    public void removeCategory() {

    }
}
