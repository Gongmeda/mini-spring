package com.gongmeda.factory;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.gongmeda.BeanDefinition;
import com.gongmeda.HelloWorldService;
import com.gongmeda.PropertyValue;
import com.gongmeda.PropertyValues;
import org.junit.jupiter.api.Test;

class BeanFactoryTest {

    @Test
    void test() throws Exception {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.gongmeda.HelloWorldService");

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");

        assertDoesNotThrow(helloWorldService::printText);
    }
}