package com.myspring.dependencyinjectiondemo.controller;

import com.myspring.dependencyinjectiondemo.controllers.PropertiyController;
import com.myspring.dependencyinjectiondemo.services.GreetingServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PropertyTest {

    private PropertiyController propertiyController;

    @Before
    public void init(){
        propertiyController = new PropertiyController();
        propertiyController.greetingServiceImp = new GreetingServiceImp();
    }

    @Test
    public void test(){
        Assert.assertEquals(GreetingServiceImp.message,propertiyController.say());
    }
}
