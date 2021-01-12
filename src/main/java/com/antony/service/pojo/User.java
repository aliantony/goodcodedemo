package com.antony.service.pojo;

import com.antony.service.mvcconverter.DateJsonDeserializer;
import com.antony.service.mvcconverter.DateJsonSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program goodcodedemo
 * @description 
 * @author wq
 * created on 2021-01-12
 * @version  1.0.0
 */
@Data
public class User {

    /**
     * 传递的此格式的参数转化为date
     * 如果使用了自定义参数转化器，Spring会优先使用该方式进行处理，即Spring注解不生效
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    /**
     * 方式一 使用springboot自带的注解@JsonFormat(pattern = "yyyy-MM-dd")
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date releaseDate;

    /**
     * 方式二 自定义日期序列化与反序列化
     */
    @JsonSerialize(using = DateJsonSerializer.class)
    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date endDate;
}
