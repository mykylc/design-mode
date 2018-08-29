package com.ky.design.mode.singleton;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/6/18 上午12:00
 * @className com.ky.design.mode.singleton.LazySingleton
 * @description 懒汉式单例，延迟加载：实例在被使用的时候才被创建，可以节省系统资源，体现了延迟加载的思想
 *              多线程安全
 **/
public class LazySafeSingleton {

    /**
     *  防止在该类外部通过new的形式创建实例
     **/
    private LazySafeSingleton(){
        System.out.println("实例化LazySafeSingleton一次");
    }

    /**
     *  私有的、静态的实例，设置为私有的防止外部直接访问该实例变量，设置为静态的，说明该实例是NoLazySingleton类型的唯一的
     *  new LazySafeSingleton() 1.分配内存空间 2.初始化对象 3.将内存空间的地址赋值给对应的引用
     *  2与3步骤存在指令重排序，因此用volatile
     **/
    private volatile static LazySafeSingleton instance = null;

    /**   
     * @author       cdchenkai1
     * @dateTime     2018/6/18 上午12:19
     * @param 
     * @return       com.ky.design.mode.singleton.LazySafeSingleton
     * @descripiton  同步锁，方法级别，锁粒度大
     **/
    public synchronized static LazySafeSingleton getInstance(){
        if (instance == null) {
            instance = new LazySafeSingleton();
        }
        return instance;
    }

    /**   
     * @author       cdchenkai1
     * @dateTime     2018/6/18 上午12:19
     * @param 
     * @return       com.ky.design.mode.singleton.LazySafeSingleton
     * @descripiton  锁代码块，锁粒度相对小，若instance已经初始化就不需要加锁；采用DCL(Double checked locking)
     **/
    public static LazySafeSingleton getInstance1(){
        if (instance == null) {
            synchronized (LazySafeSingleton.class) {
                if (instance == null) {
                    instance = new LazySafeSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //单线程访问
        //singleThread();

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
        LazySafeSingleton instance1 = LazySafeSingleton.getInstance();
        LazySafeSingleton instance2 = LazySafeSingleton.getInstance();
        LazySafeSingleton instance3 = LazySafeSingleton.getInstance();

        System.out.println("instance1=" + instance1);
        System.out.println("instance2=" + instance2);
        System.out.println("instance3=" + instance3);
    }

    /**
     * @author       cdchenkai1
     * @dateTime     2018/6/18 上午12:10
     * @param
     * @return       void
     * @descripiton  多线程创建实例，线程安全
     **/
    public static void multiThread(){
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                LazySafeSingleton instance = LazySafeSingleton.getInstance1();
                System.out.println("多线程instance=" + instance);
            }).start();
        }
    }
}
