package ru.kuzmin.rent.equipment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmin.rent.equipment.services.interfaces.CategoryService;
import ru.kuzmin.rent.equipment.dao.CategoryDao;
import ru.kuzmin.rent.equipment.entities.Category;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category save(Category category) {
        if (category.getId() == null) {
            category = categoryDao.insert(category);
        } else {
            categoryDao.update(category);
        }
        return category;
    }

    @Override
    public void delete(Long categoryId) {
        Objects.requireNonNull(categoryId);
        Category category = categoryDao.load(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category with id = " + categoryId + " not found"));
        delete(category);
    }

    @Override
    public void addSubcategory(Long categoryId, Long subcategoryId) {
        Objects.requireNonNull(categoryId);
        Objects.requireNonNull(subcategoryId);
        Category category = categoryDao.load(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category with id = " + categoryId + " not found"));
        Category subcategory = categoryDao.load(subcategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category with id = " + subcategoryId + " not found"));
        addSubcategory(category, subcategory);
    }

    @Override
    public void removeSubcategory(Long categoryId, Long subcategoryId) {
        Objects.requireNonNull(categoryId);
        Objects.requireNonNull(subcategoryId);
        Category category = categoryDao.load(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category with id = " + categoryId + " not found"));
        Category subcategory = categoryDao.load(subcategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category with id = " + subcategoryId + " not found"));
        removeSubcategory(category, subcategory);
    }

    @Override
    public List<Category> getSubcategories(Long categoryId) {
        Objects.requireNonNull(categoryId);
        Category category = categoryDao.load(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category with id = " + categoryId + " not found"));
        return getSubcategories(category);
    }

    @Override
    public void delete(Category category) {
        if (!getSubcategories(category).isEmpty()) {
            throw new IllegalStateException("Category with id = " + category.getId() + " has subcategories");
        }
        categoryDao.delete(category);
    }

    @Override
    public void addSubcategory(Category category, Category subcategory) {
        subcategory.setParentId(category.getId());
        categoryDao.update(subcategory);
    }

    @Override
    public void removeSubcategory(Category category, Category subcategory) {
        if (Objects.equals(subcategory.getParentId(), category.getId())) {
            subcategory.setParentId(null);
            categoryDao.update(subcategory);
        } else {
            throw new IllegalStateException("Category with id = " + category + " isn't parent category");
        }
    }

    @Override
    public List<Category> getSubcategories(Category category)  {
        return categoryDao.loadSubcategories(category);
    }
}
