package ru.kuzmin.rent.equipment.sdk.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EquipmentType {

    private final Long id;

    private String name;

    private Long categoryId;

    @JsonCreator
    public EquipmentType(@JsonProperty("id") Long id,
                         @JsonProperty("name") String name,
                         @JsonProperty("category") Long categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;

        private String name;

        private Long categoryId;

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

        public Builder withCategoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public EquipmentType build() {
            return new EquipmentType(id, name, categoryId);
        }
    }
}
