package ru.kuzmin.rent.equipment.sdk.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Equipment {

    private final Long id;

    private String name;

    private Long typeId;

    private Long shopId;

    @JsonCreator
    public Equipment(@JsonProperty("id") Long id,
                     @JsonProperty("name")  String name,
                     @JsonProperty("type") Long typeId,
                     @JsonProperty("shop") Long shopId) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.shopId = shopId;
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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;

        private String name;

        private Long typeId;

        private Long shopId;

        private Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withTypeId(Long typeId) {
            this.typeId = typeId;
            return this;
        }

        public Builder withShopId(Long shopId) {
            this.shopId = shopId;
            return this;
        }

        public Equipment build() {
            return new Equipment(id, name, typeId, shopId);
        }
    }
}
