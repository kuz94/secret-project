package ru.kuzmin.secret.core.bean.interfaces;

import ru.kuzmin.secret.core.entity.Category;

import java.util.List;

public interface CategoryService {

    long create(Category category);

    void update(Category category);

    void remove(Category category);

    List<CategoryContent> getContent(Category parentCategory);

}
