package com.ky.design.mode.decorator;

import java.util.List;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/7/28 下午4:17
 * @className com.ky.design.mode.decorator.Executor
 * @description 装饰器接口
 **/
public interface Executor {

    int update(String sql);

    <E> List<E> query(String sql);

    void commit(boolean autoCommit);
}
