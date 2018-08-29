package com.ky.design.mode.proxy;

/**
 * @author cdchenkai1
 * @company 京东成都研究院-供应链
 * @dateTime 2018/7/23 上午9:17
 * @className com.ky.design.mode.proxy.UserServiceImpl
 * @description
 **/
public class UserServiceImpl implements UserService {

    @Override
    public void print(String str) {
        System.out.println("userServiceImpl#print,param:" + str);
    }
}
