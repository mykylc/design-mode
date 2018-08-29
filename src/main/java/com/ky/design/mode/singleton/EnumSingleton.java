package com.ky.design.mode.singleton;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/6/18 上午12:00
 * @className com.ky.design.mode.singleton.EnumSingleton
 * @description 枚举实现单例，枚举实现了序列化接口，枚举单例有序列化和线程安全的保证
 *              多线程安全
 **/
public enum EnumSingleton {

    INSTANCE;
}
