package ru.kuzmin.secret.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kuzmin.secret.core.bean.interfaces.CategoryService;
import ru.kuzmin.secret.core.dao.CategoryDao;
import ru.kuzmin.secret.core.entity.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public long create(Category category) {
        return 0;
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void remove(Category category) {

    }

    @Override
    public List<CategoryContent> getContent(Category parentCategory) {
        return null;
    }

}
