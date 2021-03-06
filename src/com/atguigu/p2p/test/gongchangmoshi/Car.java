package com.atguigu.p2p.test.gongchangmoshi;

/**
 *
 * 就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 * 简单工厂模式的实质是由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类（这些产品类继承自一个父类或接口）的实例。
 * Created by njy on 2018/3/26.
 */
public abstract class Car {
    public abstract void say();
}
