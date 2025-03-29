package com.gongmeda.beans.xml;

import static org.junit.jupiter.api.Assertions.*;

import com.gongmeda.beans.BeanDefinition;
import com.gongmeda.HelloWorldService;
import com.gongmeda.beans.io.ResourceLoader;
import java.util.Map;
import org.junit.jupiter.api.Test;

class XmlBeanDefinitionReaderTest {

    @Test
    void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("application.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();

        assertFalse(registry.isEmpty());
        assertEquals(registry.get("helloWorldService").getBeanClass(), HelloWorldService.class);
    }
}