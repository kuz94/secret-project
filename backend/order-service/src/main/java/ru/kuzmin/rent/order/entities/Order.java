package ru.kuzmin.rent.order.entities;

import java.util.Date;

public class Order {

    private final Long id;

    private Long shopId;

    private Long userId;

    private Long equipmentId;

    private Date startTime;

    private Order(Long id, Long shopId, Long userId, Long equipmentId, Date startTime) {
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

    public Date getStartTime() {
        return startTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long shopId;
        private Long userId;
        private Long equipmentId;
        private Date startTime;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withShopId(Long shopId) {
            this.shopId = shopId;
            return this;
        }

        public Builder withUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder withEquipmentId(Long equipmentId) {
            this.equipmentId = equipmentId;
            return this;
        }

        public Builder withStartTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public Order build() {
            return new Order(id, shopId, userId, equipmentId, startTime);
        }
    }
}
