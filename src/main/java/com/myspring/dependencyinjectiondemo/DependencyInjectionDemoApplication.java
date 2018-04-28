package com.myspring.dependencyinjectiondemo;

import com.myspring.dependencyinjectiondemo.controllers.ContrructorController;
import com.myspring.dependencyinjectiondemo.controllers.MyController;
import com.myspring.dependencyinjectiondemo.controllers.PropertiyController;
import com.myspring.dependencyinjectiondemo.controllers.SetterController;
import com.myspring.dependencyinjectiondemo.propertybean.MyDataSourceBean;
import com.myspring.dependencyinjectiondemo.propertybean.MyKafkaBean;
import com.myspring.dependencyinjectiondemo.propertybean.MyMainBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

    public static void main(String[] args) {

        ApplicationContext ac = SpringApplication.run(DependencyInjectionDemoApplication.class, args);

        MyMainBean mainBean =ac.getBean(MyMainBean.class);
        System.out.println(mainBean.getMainUrl());

        MyDataSourceBean dataSource =ac.getBean(MyDataSourceBean.class);
        System.out.println(dataSource.getUsername());

        MyKafkaBean kafkaBean =ac.getBean(MyKafkaBean.class);
        System.out.println(kafkaBean.getUsername());

        MyController myController = (MyController) ac.getBean("myController");
        myController.hello();

        System.out.println(ac.getBean(ContrructorController.class).say());
        System.out.println(ac.getBean(PropertiyController.class).say());
        System.out.println(ac.getBean(SetterController.class).say());


    }
}
