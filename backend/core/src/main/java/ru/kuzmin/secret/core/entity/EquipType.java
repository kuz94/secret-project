package ru.kuzmin.secret.core.entity;

public class EquipType {

    private long id;

    private String name;

    private long parentTypeId;

    private EquipType parentType;

    public EquipType(long id, String name, long parentTypeId) {
        this.id = id;
        this.name = name;
        this.parentTypeId = parentTypeId;
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
