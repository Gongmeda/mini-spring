package com.gongmeda.beans.factory;

public interface BeanFactory {

    Object getBean(String name) throws Exception;
}
