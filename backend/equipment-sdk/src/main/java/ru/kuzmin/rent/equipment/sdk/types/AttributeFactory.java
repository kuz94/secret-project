package ru.kuzmin.rent.equipment.sdk.types;

import ru.kuzmin.rent.equipment.sdk.entities.DataType;

import java.text.ParseException;

public class AttributeFactory {

    public static CommonValue createAttribute(DataType type, String value, Boolean nullable) throws ParseException {
        switch (type) {
            case STRING:
                return new StringValue(value, nullable);
            case INTEGER:
                return new IntegerValue(value, nullable);
            case FLOAT:
                return new FloatValue(value, nullable);
            case DATE:
                return new DateValue(value, nullable);
            case BOOLEAN:
                return new BooleanValue(value, nullable);
            default:
                throw new IllegalArgumentException("Attribute type is unknown");
        }
    }
}
