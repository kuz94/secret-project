package ru.kuzmin.rent.equipment.types;

import java.text.ParseException;
import java.util.Objects;

public abstract class CommonValue<T> {
    private Boolean nullable;

    private T value;

    public CommonValue(String value, Boolean nullable) throws ParseException{
        this.nullable = Objects.requireNonNull(nullable);

        if (!isNullable()) {
            Objects.requireNonNull(value);
        }

        this.value = parse(isNullable() ? value : Objects.requireNonNull(value));
    }

    public T value() {
        return value;
    }

    public Boolean isNullable() {
        return nullable;
    }

    protected abstract T parse(String value) throws ParseException;
}
