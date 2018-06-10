package com.atguigu.p2p.test.SingletonTest;

/**
 * 保证一个类只能有一个实例，并提供一个访问他的全局访问点
 * tatic表示“全局”或者“静态”的意思，用来修饰成员变量和成员方法，也可以形成静态static代码块，但是Java语言中没有全局变量的概念。
 被static修饰的成员变量和成员方法独立于该类的任何对象。也就是说，它不依赖类特定的实例，被类的所有实例共享。
 只要这个类被加载，Java虚拟机就能根据类名在运行时数据区的方法区内定找到他们。因此，static对象可以在它的任何对象创建之前访问，无需引用任何对象。
 * Created by njy on 2018/3/27.
 */
public class SingletonTest {
    private static SingletonTest instance = null;

    private SingletonTest() {
    }
    public static SingletonTest getInstance() {
        if (instance != null){
            synInit();
        }
        return instance;
    }
    private static synchronized void synInit(){
        if (instance != null){
            instance = new SingletonTest();
        }
    }

}
