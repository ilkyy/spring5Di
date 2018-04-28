package com.myspring.dependencyinjectiondemo.config;

import com.myspring.dependencyinjectiondemo.propertybean.MyDataSourceBean;
import com.myspring.dependencyinjectiondemo.propertybean.MyKafkaBean;
import com.myspring.dependencyinjectiondemo.propertybean.MyMainBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class MyDataSourceConfig {

    // via environment properties
    @Autowired
    Environment environment;

    // application.properties
    @Value("${mainUrl}")
    String mainUrl;

    // application.yml
    @Value("${myspring.ymlurl}")
    String ymlurl;

    // datasource*.properties---
    @Value("${dbusername}")
     String dbuser;

    @Value("${dbpassword}")
     String dbpass;

    @Value("${dburl}")
     String dburl;
    //--------------------------

    //kafka*.properties---------
    @Value("${kafkausername}")
    String kafkauser;

    @Value("${kafkapassword}")
    String kafkapass;

    @Value("${kafkaurl}")
    String kafkaurl;
    //--------------------------

    @Bean
    public MyMainBean myMainBean(){
        MyMainBean myMainBean = new MyMainBean();
        myMainBean.setMainUrl("application.properties: "+mainUrl+" - application.yml: "+ymlurl);
        return myMainBean;
    }

    @Bean
    public MyDataSourceBean myDataSource(){
        MyDataSourceBean dataSource = new MyDataSourceBean();
        dataSource.setUsername(environment.getProperty("USERNAME")); // with env properties override
        dataSource.setPass(dbpass);
        dataSource.setUrl(dburl);
        return dataSource;
    }

    @Bean
    public MyKafkaBean kafkaBean(){
        MyKafkaBean kafkaBean = new MyKafkaBean();
        kafkaBean.setUsername(kafkauser);
        kafkaBean.setPass(kafkapass);
        kafkaBean.setUrl(kafkaurl);
        return kafkaBean;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig(String env){
        // application.properties is already injected
        String dbProperties = "datasource"+env+".properties";
        String kafkaProperties = "kafka"+env+".properties";
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setLocations(new ClassPathResource(dbProperties),new ClassPathResource(kafkaProperties)); // change with profile
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    @Profile("alpha")
    public static String localProfile(){
        return "alpha";
    }

    @Bean
    @Profile("prod")
    public static String prodProfile(){
        return "prod";
    }

}
