package com.atguigu.p2p.test.dailimoshi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1.代理对象,不需要实现接口
 2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
 3.动态代理也叫做:JDK代理,接口代理
 Interface InvocationHandler：该接口中仅定义了一个方法Object：invoke(Object obj,Method method, Object[] args)。在实际使用时，第一个参数obj一般是指代理 类，method是被代理的方法，如上例中的request()，args为该方法的参数数组。 这个抽 象方法在代理类中动态实现。
 Proxy：该类即为动态代理类，作用类似于上例中的ProxySubject。
 Protected Proxy(InvocationHandler h)：构造函数，估计用于给内部的h赋值。
 Static Class getProxyClass (ClassLoader loader, Class[] interfaces)：获得一个 代理类，其中loader是类装载器，interfaces是真实类所拥有的全部接口的数组。
 Static Object newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h)：返回代理类的一个实例，返回后的代理类可以当作被代理类使用 (可使用被代理类的在Subject接口中声明过的方法)
 * Created by njy on 2018/3/26.
 */
public class ProxyFactory {
    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }
    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务2");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("提交事务2");
                        return returnValue;
                    }
                }
        );
    }
}
