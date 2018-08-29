package com.ky.design.mode.singleton;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/6/18 上午12:00
 * @className com.ky.design.mode.singleton.LazySingleton
 * @description 懒汉式单例，延迟加载：实例在被使用的时候才被创建，可以节省系统资源，体现了延迟加载的思想
 *              多线程不安全
 **/
public class LazySingleton {

    /**
     *  防止在该类外部通过new的形式创建实例
     **/
    private LazySingleton(){
        System.out.println("实例化LazySingleton一次");
    }

    /**
     *  私有的、静态的实例，设置为私有的防止外部直接访问该实例变量，设置为静态的，说明该实例是NoLazySingleton类型的唯一的
     **/
    private static LazySingleton instance = null;

    public static LazySingleton getInstance(){
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
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
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        LazySingleton instance3 = LazySingleton.getInstance();

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
                LazySingleton instance = LazySingleton.getInstance();
                System.out.println("多线程instance=" + instance);
            }).start();
        }
    }
}
