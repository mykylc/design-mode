package com.ky.design.mode.decorator;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/7/28 下午4:34
 * @className com.ky.design.mode.decorator.DecoratorTest
 * @description 装饰器模式
 **/
public class DecoratorTest {

    public static void main(String[] args) {
        //被装饰类
        SimpleExecutor simpleExecutor = new SimpleExecutor();

        //装饰类
        CachingExecutor cachingExecutor = new CachingExecutor(simpleExecutor);

        cachingExecutor.commit(true);

    }
}
