package ru.kuzmin.secret.core.entity;

import java.util.List;

public class EquipmentType {

    private long id;

    private String name;

    private long categoryId;

    private List<EquipmentAttribute> attributes;

    public EquipmentType(long id, String name, Long categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
