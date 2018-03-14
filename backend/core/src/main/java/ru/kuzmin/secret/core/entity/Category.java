package ru.kuzmin.secret.core.entity;

public class Category {

    private Long id;

    private final String name;

    private Long parentId;

    public Category(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getParentId() {
        return parentId;
    }
}
