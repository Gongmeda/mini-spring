package com.gongmeda;

public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(String text){
        assert helloWorldService != null;
        System.out.println(text);
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
