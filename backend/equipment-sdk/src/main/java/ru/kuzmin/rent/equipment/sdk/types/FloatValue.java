package ru.kuzmin.rent.equipment.sdk.types;

import java.text.ParseException;

public class FloatValue extends CommonValue<Float> {

    public FloatValue(String value, Boolean nullable) throws ParseException {
        super(value, nullable);
    }

    @Override
    protected Float parse(String value) throws ParseException {
        return Float.valueOf(value);
    }
}
