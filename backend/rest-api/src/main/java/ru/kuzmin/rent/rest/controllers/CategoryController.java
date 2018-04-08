package ru.kuzmin.rent.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    /*
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
    */
}
