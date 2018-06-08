package com.yur.springboot;

//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class SpringMVCConfig extends WebMvcConfigurerAdapter {


    /*@Autowired
    private StringHttpMessageConverter stringHttpMessageConverter;
    @Autowired
    private MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter;

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(mappingJacksonHttpMessageConverter);
        converters.add(stringHttpMessageConverter);

    }*/

    /*public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
        System.out.println("init convert is start !!!!!");
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setWriteAcceptCharset(false);
        messageConverters.add(stringConverter);
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        System.out.println("init convert is stop !!!!!");
    }*/

  /*  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        //1.创建一个convert消息转换对象
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        //2.创建一个fastJson的配置对象,然后配置格式化信息
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //3.在convert中添加配置信息
        fastConvert.setFastJsonConfig(config);
        //4.将convert添加到converts里面
        converters.add(fastConvert);
    }*/
}
