package ru.kuzmin.rent.equipment.sdk.types;

import java.text.ParseException;

public class StringValue extends CommonValue<String> {

    StringValue(String value, Boolean nullable) throws ParseException {
        super(value, nullable);
    }

    @Override
    public String parse(String value) {
        return value;
    }
}
