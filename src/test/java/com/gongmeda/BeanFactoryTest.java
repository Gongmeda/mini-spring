package com.gongmeda;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.gongmeda.beans.BeanDefinition;
import com.gongmeda.beans.factory.AbstractBeanFactory;
import com.gongmeda.beans.factory.AutowireCapableBeanFactory;
import com.gongmeda.beans.io.ResourceLoader;
import com.gongmeda.beans.xml.XmlBeanDefinitionReader;
import java.util.Map;
import org.junit.jupiter.api.Test;

class BeanFactoryTest {

    @Test
    void testLazy() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("application.xml");

        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        assertDoesNotThrow(helloWorldService::printText);
    }

    @Test
    public void testPreInstantiate() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("application.xml");

        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        beanFactory.preInstantiateSingletons();

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        assertDoesNotThrow(helloWorldService::printText);
    }
}