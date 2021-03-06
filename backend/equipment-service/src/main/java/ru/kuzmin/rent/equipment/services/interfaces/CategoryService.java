package ru.kuzmin.rent.equipment.services.interfaces;

import ru.kuzmin.rent.equipment.entities.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    void delete(Long categoryId);

    void addSubcategory(Long categoryId, Long subcategoryId);

    void removeSubcategory(Long categoryId, Long subcategoryId);

    List<Category> getSubcategories(Long categoryId);

    void delete(Category category);

    void addSubcategory(Category category, Category subcategory);

    void removeSubcategory(Category category, Category subcategory);

    List<Category> getSubcategories(Category category);
}
