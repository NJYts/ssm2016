package com.atguigu.p2p.test.gongchangmoshi;

/**
 * Created by njy on 2018/3/26.
 */
public class FactoryClient {
    public static void main(String[] args) {

        Car Benz = SampleFactory.makeCar(Benz.class);
        Benz.say();
        Car Bmw = SampleFactory.makeCar(Bmw.class);
        Bmw.say();
    }
}
