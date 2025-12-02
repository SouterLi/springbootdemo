package com.aiden.service.impl;

public class ThreadTestServiceImpl {

    public String getThreadLocalValue() {
        ThreadLocal<String> aa = new ThreadLocal<>();
        aa.set("hello");
        return aa.get();
    }
}
