package ru.kuzmin.secret.core.entity;

public class EquipmentType extends CategoryContent {

    private long id;

    private String name;

    public EquipmentType(long id, String name, Long categoryId) {
        this.id = id;
        this.name = name;
        this.parentCategoryId = categoryId;
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

    public void setName(String name) {
        this.name = name;
    }
}
