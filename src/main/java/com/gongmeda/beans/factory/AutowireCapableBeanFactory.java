package com.gongmeda.beans.factory;

import com.gongmeda.beans.BeanReference;
import com.gongmeda.beans.BeanDefinition;
import com.gongmeda.beans.PropertyValue;
import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);

            Object value = propertyValue.getValue();
            if (value instanceof BeanReference beanReference) {
                value = beanReference.getBean();
            }

            declaredField.set(bean, value);
        }
    }
}
