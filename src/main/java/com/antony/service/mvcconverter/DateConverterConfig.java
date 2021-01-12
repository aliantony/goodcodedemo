package com.antony.service.mvcconverter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Configuration
public class DateConverterConfig {

    /**
     * 使用lambda必须要加@ConditionalOnBean(name = "requestMappingHandlerAdapter")
     * web项目启动注册requestMappingHandlerAdapter的时候会初始化WebBindingInitializer
     * 而ConfigurableWebBindingInitializer需要FormattingConversionService,
     * 而FormattingConversionService会将所有的Converter添加进来,通过接口Converter获取不到lambda
     * 格式的泛型信息
     * @return
     */
    @Bean
    @ConditionalOnBean(name = "requestMappingHandlerAdapter")
    public Converter<String, LocalDate> localDateConverter() {
       return source -> LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Bean
    @ConditionalOnBean(name = "requestMappingHandlerAdapter")
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return source -> LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}