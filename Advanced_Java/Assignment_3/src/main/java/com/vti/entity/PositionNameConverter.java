package com.vti.entity;

import javax.persistence.AttributeConverter;

public class PositionNameConverter implements AttributeConverter<Position.PositionName, String> {
    @Override
    public String convertToDatabaseColumn(Position.PositionName positionName) {
        if (positionName == null) {
            return null;
        }
        return positionName.getSqlPositionName();
    }

    @Override
    public Position.PositionName convertToEntityAttribute(String sqlPositionName) {
        if (sqlPositionName == null) {
            return null;
        }
        return Position.PositionName.toEnum(sqlPositionName);
    }
}
