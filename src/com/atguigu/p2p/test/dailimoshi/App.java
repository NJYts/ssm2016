package com.atguigu.p2p.test.dailimoshi;

/**
 * Created by njy on 2018/3/26.
 */
public class App {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);

        proxy.save();//执行的是代理的方法
        //**************************************************************
        // 目标对象
        IUserDao targetDT = new UserDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(targetDT.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxyDT = (IUserDao) new ProxyFactory(targetDT).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxyDT.getClass());

        // 执行方法   【代理对象】
        proxy.save();
        //**************************************************************
        //目标对象
        UserDao1 target1 = new UserDao1();

        //代理对象
        UserDao1 proxy1 = (UserDao1)new ProxyFactoryCglib(target1).getProxyInstance();

        //执行代理对象的方法
        proxy1.save();
    }
}
