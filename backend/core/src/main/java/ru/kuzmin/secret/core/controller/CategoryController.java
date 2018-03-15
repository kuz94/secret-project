package ru.kuzmin.secret.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzmin.secret.core.bean.interfaces.CategoryService;
import ru.kuzmin.secret.core.entity.Category;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getRootCategories() {
        return categoryService.getSubcategories((Category) null);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<Category> getSubcategories(Long categoryId) {
        return categoryService.getSubcategories(categoryId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Category create(Category category) {
        return categoryService.save(category);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void remove(Long categoryId) {
        categoryService.delete(categoryId);
    }

    @RequestMapping(path = "/{id}/add", method = RequestMethod.PUT)
    public void createNested(Long categoryId, Long subcategoryId) {
        categoryService.addSubcategory(categoryId, subcategoryId);
    }

    @RequestMapping(path = "/{id}/remove", method = RequestMethod.PUT)
    public void removeCategory(Long categoryId, Long subcategoryId) {
        categoryService.removeSubcategory(categoryId, subcategoryId);
    }
}
