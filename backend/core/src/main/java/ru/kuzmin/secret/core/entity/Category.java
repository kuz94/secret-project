package ru.kuzmin.secret.core.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    private Long id;

    private final String name;

    @JsonIgnore
    private Long parentId;

    private Long typeId;

    @JsonCreator
    public Category(@JsonProperty("id") Long id,
                    @JsonProperty("name") String name,
                    @JsonProperty("type") Long typeId) {
        this(id, name, null, typeId);
    }

    public Category(Long id, String name, Long parentId, Long typeId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.typeId = typeId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

        private Long parentId;

        private Long typeId;

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

        public Builder withParentId(Long parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder withTypeId(Long typeId) {
            this.typeId = typeId;
            return this;
        }

        public Category build() {
            return new Category(id, name, parentId, typeId);
        }
    }
}
