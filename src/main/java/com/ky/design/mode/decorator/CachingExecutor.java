package com.ky.design.mode.decorator;

import java.util.List;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/7/28 下午4:20
 * @className com.ky.design.mode.decorator.CachingExecutor
 * @description 装饰器模式
 **/
public class CachingExecutor implements Executor {

    private Executor delegate;

    public CachingExecutor(Executor delegate) {
        this.delegate = delegate;
    }

    @Override
    public int update(String sql) {
        System.out.println("cachingExecutor update");
        delegate.update(sql);
        return 0;
    }

    @Override
    public <E> List<E> query(String sql) {
        System.out.println("cachingExecutor query");
        delegate.query(sql);
        return null;
    }

    @Override
    public void commit(boolean autoCommit) {
        System.out.println("cachingExecutor commit");
        delegate.commit(autoCommit);
    }
}
