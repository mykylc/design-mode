package com.ky.design.mode.decorator;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/7/28 下午4:31
 * @className com.ky.design.mode.decorator.SimpleExecutor
 * @description
 **/
public class SimpleExecutor extends BaseExecutor {

    public void doQuery(String sql) {
        System.out.println("simpleExecutor doQuery");
    }
}
