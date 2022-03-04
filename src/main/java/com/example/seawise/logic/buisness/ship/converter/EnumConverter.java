package com.example.seawise.logic.buisness.ship.converter;

import com.example.seawise.logic.buisness.ship.domain.SectorMark;
import org.springframework.core.convert.converter.Converter;

public class EnumConverter implements Converter<String, SectorMark> {
    @Override
    public SectorMark convert(String source) {
        try {
            return SectorMark.valueOf(source);
        } catch (Exception e) {
            return null;
        }
    }
}
