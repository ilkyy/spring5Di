package com.myspring.dependencyinjectiondemo.controller;

import com.myspring.dependencyinjectiondemo.controllers.ContrructorController;
import com.myspring.dependencyinjectiondemo.services.GreetingServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConstructorTest {

    private ContrructorController contrructorController;

    @Before
    public void init(){
        contrructorController = new ContrructorController(new GreetingServiceImp());
    }

    @Test
    public void test(){
        Assert.assertEquals(GreetingServiceImp.message,contrructorController.say());
    }
}
