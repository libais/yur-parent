package com.yur.demo.pattern.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Actor actor;

    public Object getInstance(Actor actor){
        this.actor = actor;
        Class clazz = actor.getClass();
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("经理人谈价格。。。");
        method.invoke(actor, args);
        System.out.println("经理人拿到钱。。。");
        return null;
    }


}
