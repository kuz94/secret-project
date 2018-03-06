package ru.kuzmin.secret.core.entity;

public class EquipmentAttribute {

    private long id;

    private String name;

    private long equipmentTypeId;

    private DataType dataType;

    public EquipmentAttribute(long id, String name, long equipmentTypeId, DataType dataType) {
        this.id = id;
        this.name = name;
        this.equipmentTypeId = equipmentTypeId;
        this.dataType = dataType;
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

    public long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }
}
