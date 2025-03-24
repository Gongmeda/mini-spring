package com.gongmeda.factory;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.gongmeda.BeanDefinition;
import com.gongmeda.HelloWorldService;
import org.junit.jupiter.api.Test;

class BeanFactoryTest {

    @Test
    void test() {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.gongmeda.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");

        assertDoesNotThrow(helloWorldService::helloWorld);
    }
}