package ru.kuzmin.rent.equipment.entities;

public class Equipment {

    private long id;

    private String name;

    private long typeId;

    private long shopId;

    public Equipment(long id, String name,  long typeId, long shopId) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.shopId = shopId;
    }

    public long getId() {
        return id;
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
