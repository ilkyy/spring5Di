package com.myspring.dependencyinjectiondemo;

import com.myspring.dependencyinjectiondemo.controllers.ContrructorController;
import com.myspring.dependencyinjectiondemo.controllers.MyController;
import com.myspring.dependencyinjectiondemo.controllers.PropertiyController;
import com.myspring.dependencyinjectiondemo.controllers.SetterController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyinjectiondemoApplication {

    public static void main(String[] args) {

        ApplicationContext ac = SpringApplication.run(DependencyinjectiondemoApplication.class, args);
        MyController myController = (MyController) ac.getBean("myController");
        myController.hello();

        System.out.println(ac.getBean(ContrructorController.class).say());
        System.out.println(ac.getBean(PropertiyController.class).say());
        System.out.println(ac.getBean(SetterController.class).say());
    }
}
