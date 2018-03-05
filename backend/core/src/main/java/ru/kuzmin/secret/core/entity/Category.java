package ru.kuzmin.secret.core.entity;

public class Category extends CategoryContent {

    private final Long id;

    private final String name;

    }

    public Category(long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentCategoryId = parentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public static class Builder {

        public Category build() {
            return new
        }
    }

}
