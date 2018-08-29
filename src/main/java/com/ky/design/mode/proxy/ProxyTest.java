package com.ky.design.mode.proxy;

import java.lang.reflect.Proxy;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/7/23 上午9:26
 * @className com.ky.design.mode.proxy.ProxyTest
 * @description
 *
 * JDK动态代理的大致流程：
 * 1. 获取 代理类上的所有接口列表；
 * 2. 确定要生成的代理类的类名；
 * 3. 根据需要实现的接口信息，在代码中动态创建该Proxy类的字节码；
 * 4. 将对应的字节码转换为对应的class 对象；
 * 5. 创建InvocationHandler 实例handler，用来处理Proxy所有方法调用；
 * 6. Proxy 的class对象 以创建的handler对象为参数，实例化一个proxy对象
 *
 **/
public class ProxyTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);

        Object proxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                userService.getClass().getInterfaces(), myInvocationHandler);

        UserService proxy = (UserService) proxyInstance;
        proxy.print("2321312");
    }
}
