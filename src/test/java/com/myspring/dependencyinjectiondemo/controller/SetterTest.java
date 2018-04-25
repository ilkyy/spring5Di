package com.myspring.dependencyinjectiondemo.controller;

import com.myspring.dependencyinjectiondemo.controllers.SetterController;
import com.myspring.dependencyinjectiondemo.services.GreetingServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetterTest {

    private SetterController setterController;

    @Before
    public void init(){
        setterController = new SetterController();
        setterController.setGreetingService(new GreetingServiceImp());
    }

    @Test
    public void test(){
        Assert.assertEquals(GreetingServiceImp.message,setterController.say());
    }
}
