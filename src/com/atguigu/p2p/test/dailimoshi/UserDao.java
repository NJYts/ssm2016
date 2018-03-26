package com.atguigu.p2p.test.dailimoshi;

/**
 * Created by njy on 2018/3/26.
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("---- 保存成功 ----");
    }
}
