package ru.kuzmin.secret.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmin.secret.core.bean.interfaces.CategoryService;
import ru.kuzmin.secret.core.dao.CategoryDao;
import ru.kuzmin.secret.core.entity.Category;

import java.util.List;

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
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Override
    public List<Category> getSubcategories(Category category) {
        return category == null
                ? categoryDao.loadRootCategories()
                : categoryDao.loadSubcategories(category);
    }

}
