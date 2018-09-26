package com.ky.design.mode.singleton;

import java.math.BigDecimal;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/6/18 上午12:00
 * @className com.ky.design.mode.singleton.LazySingleton
 * @description 懒汉式单例，利用内部类延迟加载：实例在被使用的时候才被创建，可以节省系统资源，体现了延迟加载的思想
 *              多线程安全
 **/
public class LazyInnerClassSingleton {

    /**
     *  防止在该类外部通过new的形式创建实例
     **/
    private LazyInnerClassSingleton(){
        System.out.println("实例化LazyInnerClassSingleton一次");
    }

    /**
     *  类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载;
     *  当LazyInnerClassSingleton被加载的时候，其内部类并不会被初始化，
     *  所以可以保证当LazyInnerClassSingleton被装载到JVM的时候，不会实例化单例类，
     *  当外部调用getInstance方法的时候，才会加载内部类SingletonHandler，从而实例化instance,
     *  同时由于实例的建立是在类初始化时完成的，所以天生对多线程友好，getInstance方法也不需要进行同步
     **/
    private static class SingletonHandler{
        /**
         *  静态初始化器，由JVM来保证线程安全
         *  final 为了防止内部误操作，防止代理模式：cglib
         **/
        private static final LazyInnerClassSingleton instance = new LazyInnerClassSingleton();
    }

    /**
     * final 确保别人不能被覆盖
     **/
    public static final LazyInnerClassSingleton getInstance(){
        return SingletonHandler.instance;
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(4);
        System.out.println(bigDecimal.toString());
        //单线程访问
        singleThread();

        //多线程访问
        multiThread();
    }

    /**
     * @author       cdchenkai1
     * @dateTime     2018/6/18 上午12:13
     * @param
     * @return       void
     * @descripiton  单线程创建实例不存在线程安全问题
     **/
    public static void singleThread(){
        LazyInnerClassSingleton instance1 = LazyInnerClassSingleton.getInstance();
        LazyInnerClassSingleton instance2 = LazyInnerClassSingleton.getInstance();
        LazyInnerClassSingleton instance3 = LazyInnerClassSingleton.getInstance();

        System.out.println("instance1=" + instance1);
        System.out.println("instance2=" + instance2);
        System.out.println("instance3=" + instance3);
    }

    /**
     * @author       cdchenkai1
     * @dateTime     2018/6/18 上午12:10
     * @param
     * @return       void
     * @descripiton  多线程创建实例，存在线程不安全
     **/
    public static void multiThread(){
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                LazyInnerClassSingleton instance = LazyInnerClassSingleton.getInstance();
                System.out.println("多线程instance=" + instance);
            }).start();
        }
    }
}
