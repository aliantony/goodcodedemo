package com.antony.service.mvcconverter;

import cn.hutool.core.date.DateUtil;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

//@Component
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String value) {
        /**
         * 可对value进行正则匹配，支持日期、时间等多种类型转换
         * 这里我偷个懒，在匹配Date日期格式时直接使用了 hutool 为我们已经写好的解析工具类，这里就不重复造轮子了
         * cn.hutool.core.date.DateUtil
         * @param value
         * @return
         */
        return DateUtil.parse(value.trim());
    }
}