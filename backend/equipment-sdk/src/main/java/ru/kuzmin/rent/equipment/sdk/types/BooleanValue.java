package ru.kuzmin.rent.equipment.sdk.types;

import java.text.ParseException;

public class BooleanValue extends CommonValue<Boolean> {

    public BooleanValue(String value, Boolean nullable) throws ParseException {
        super(value, nullable);
    }

    @Override
    protected Boolean parse(String value) {
        return Boolean.valueOf(value);
    }
}
