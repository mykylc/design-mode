package com.ky.design.mode.decorator;

import java.util.List;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/7/28 下午4:22
 * @className com.ky.design.mode.decorator.BaseExecutor
 * @description
 **/
public abstract class BaseExecutor implements Executor {

    @Override
    public int update(String sql) {
        System.out.println("baseExecutor update");
        return 121;
    }

    @Override
    public <E> List<E> query(String sql) {
        System.out.println("baseExecutor query");
        return null;
    }

    @Override
    public void commit(boolean autoCommit) {
        System.out.println("baseExecutor commit");
    }
}
