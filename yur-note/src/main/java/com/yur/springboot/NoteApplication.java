package com.yur.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@EnableAutoConfiguration
@PropertySource(value = { "classpath:jdbc.properties" }, ignoreResourceNotFound = true)
@ComponentScan(basePackages = "com.yur")
@SpringBootApplication
public class NoteApplication extends SpringBootServletInitializer {

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driver}")
    private String jdbcDriver;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() {
        DruidDataSource dds = new DruidDataSource();
        // 数据库驱动
        dds.setDriverClassName(jdbcDriver);
        // 相应驱动的jdbcUrl
        dds.setUrl(jdbcUrl);
        // 数据库的用户名
        dds.setUsername(jdbcUsername);
        // 数据库的密码
        dds.setPassword(jdbcPassword);

        /*// 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
        // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
        boneCPDataSource.setIdleMaxAgeInMinutes(30);
        // 每个分区最大的连接数
        boneCPDataSource.setMaxConnectionsPerPartition(100);
        // 每个分区最小的连接数
        boneCPDataSource.setMinConnectionsPerPartition(5);*/

        return dds;
    }

    /*@Bean
    public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        MediaType mediaType = new MediaType("text/html;charset=UTF-8");
//        List<MediaType> list = new ArrayList<>();
//        list.add(mediaType);
//        converter.setSupportedMediaTypes(list);
        return converter;
    }
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter(){

        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
//        MediaType mediaType = new MediaType("text/html;charset=UTF-8");
//        List<MediaType> list = new ArrayList<>();
//        list.add(mediaType);
//        MediaType mediaType2 = new MediaType("application/x-javascript;charset=UTF-8");
//        list.add(mediaType2);
//        stringHttpMessageConverter.setSupportedMediaTypes(list);

        return stringHttpMessageConverter;
    }*/


 /*   @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NoteAppController.class);
    }*/

}
