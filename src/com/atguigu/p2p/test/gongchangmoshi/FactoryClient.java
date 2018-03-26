package com.atguigu.p2p.test.gongchangmoshi;

/**
 * Created by njy on 2018/3/26.
 */
public class FactoryClient {
    public static void main(String[] args) {

        Human man = SampleFactory.makeHuman("man");
        man.say();
        Human womman = SampleFactory.makeHuman("womman");
        womman.say();
        Human test = SampleFactory.makeHuman("tttt");

        Human man1 = SampleFactory.makeHuman1(Man.class);
        man1.say();
        Human woman = SampleFactory.makeHuman1(Womman.class);
        woman.say();
    }
}
