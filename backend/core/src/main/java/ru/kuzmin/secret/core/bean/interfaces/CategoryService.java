package ru.kuzmin.secret.core.bean.interfaces;

import ru.kuzmin.secret.core.entity.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    void delete(Category category);

    List<Category> getSubcategories(Category category);
}
