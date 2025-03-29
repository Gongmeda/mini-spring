package com.gongmeda.context;

import static org.junit.jupiter.api.Assertions.*;

import com.gongmeda.HelloWorldService;
import org.junit.jupiter.api.Test;

class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");

        assertDoesNotThrow(helloWorldService::printText);
    }
}