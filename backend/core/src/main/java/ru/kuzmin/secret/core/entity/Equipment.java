package ru.kuzmin.secret.core.entity;

import ru.kuzmin.secret.core.types.CommonValue;

import java.util.Map;

public class Equipment {

    private long id;

    private String name;

    private long typeId;

    private long shopId;

    private Map<EquipmentAttribute, CommonValue> attributes;

    public Equipment(long id, String name,  long typeId, long shopId) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.shopId = shopId;
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

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }
}
