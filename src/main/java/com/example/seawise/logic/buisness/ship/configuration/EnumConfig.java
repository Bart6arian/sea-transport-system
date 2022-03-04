package com.example.seawise.logic.buisness.ship.configuration;

import com.example.seawise.logic.buisness.ship.converter.EnumConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class EnumConfig extends WebMvcConfigurationSupport {
    @Override
    public FormattingConversionService mvcConversionService() {
        FormattingConversionService fcs = super.mvcConversionService();
        fcs.addConverter(new EnumConverter());
        return fcs;
    }
}
