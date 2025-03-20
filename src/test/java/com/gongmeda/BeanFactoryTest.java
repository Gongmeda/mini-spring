package com.gongmeda;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BeanFactoryTest {

    @Test
    void test() {
        BeanFactory beanFactory = new BeanFactory();
        HelloWorldService service = new HelloWorldService();
        beanFactory.registerBeanDefinition("helloWorldService", new BeanDefinition(service));

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");

        assertEquals(service, helloWorldService);
        assertDoesNotThrow(helloWorldService::helloWorld);
    }

    static class HelloWorldService {
        public void helloWorld() {
            System.out.println("Hello World");
        }
    }
}