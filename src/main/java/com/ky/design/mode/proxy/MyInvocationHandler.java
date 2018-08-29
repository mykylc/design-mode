package com.ky.design.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/7/23 上午9:22
 * @className com.ky.design.mode.proxy.MyInvocationHandler
 * @description 调用处理器对象,实际工作
 **/
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 目标对象
     **/
    private Object target;

    public MyInvocationHandler(Object target){
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----before----");
        Object result = method.invoke(target, args);
        System.out.println("----after-----");
        return result;
    }
}
