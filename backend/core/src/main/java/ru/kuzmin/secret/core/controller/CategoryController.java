package ru.kuzmin.secret.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzmin.secret.core.dao.CategoryDao;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

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
