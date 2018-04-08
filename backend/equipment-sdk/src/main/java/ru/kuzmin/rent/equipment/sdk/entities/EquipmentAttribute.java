package ru.kuzmin.rent.equipment.sdk.entities;

public class EquipmentAttribute {

    private final Long id;

    private String name;

    private Long equipmentTypeId;

    private DataType dataType;

    public EquipmentAttribute(Long id,
                              String name,
                              Long equipmentTypeId,
                              DataType dataType) {
        this.id = id;
        this.name = name;
        this.equipmentTypeId = equipmentTypeId;
        this.dataType = dataType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }
}
