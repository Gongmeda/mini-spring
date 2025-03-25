package com.gongmeda;

public class HelloWorldService {

    private String text;

    public void printText() {
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
