package com.antony.service.controller;

import com.antony.service.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program goodcodedemo
 * @description
 * 如果要转换request传来的参数到我们指定的类型，根据入参注解要进行区分：
 *
 * 如果是RequestBody，那么通过配置ObjectMapper（这个玩意儿会注入到Jackson的HttpMessagConverter里面，
 * 即MappingJackson2HttpMessageConverter中）
 * 来实现Json格式数据的序列化和反序列化；如果是RequestParam或者PathVariable类型的参数，
 * 通过配置Converter实现参数转换（这些Converter会注入到ConversionService中）。
 * https://juejin.im/post/5e62817fe51d4526d05962a2
 * @author wq
 * created on 2021-01-12
 * @version  1.0.0
 */
@RestController
public class HelloController {

    /**
     * ModelAttributeMethodProcessor解析方法参数和处理返回值类型
     * @param user
     * @return
     */
    @PostMapping("/hello")
    public User hell(@RequestBody User user) {
        System.out.println(String.format("startDate:%s,releaseDate:%s,endDate:%s",
                user.getStartDate(), user.getReleaseDate(), user.getEndDate()));
        return user;
    }
}
