package ru.kuzmin.rent.order.api.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderApi{
    @JsonProperty
    private final Long id;

    @JsonProperty
    private final Long shopId;

    @JsonProperty
    private final Long userId;

    @JsonProperty
    private final Long equipmentId;

    @JsonProperty
    private final String startTime;

    @JsonCreator
    public OrderApi(@JsonProperty("id") Long id,
                    @JsonProperty("shopId") Long shopId,
                    @JsonProperty("userId") Long userId,
                    @JsonProperty("equipmentId") Long equipmentId,
                    @JsonProperty("startTime") String startTime) {
        this.id = id;
        this.shopId = shopId;
        this.userId = userId;
        this.equipmentId = equipmentId;
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public Long getShopId() {
        return shopId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public String getStartTime() {
        return startTime;
    }
}
