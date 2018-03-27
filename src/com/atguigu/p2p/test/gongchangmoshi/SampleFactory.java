package com.atguigu.p2p.test.gongchangmoshi;

/**
 * Created by njy on 2018/3/26.
 */
public class SampleFactory {
    /**
     * 逻辑控制生产
     * @param type
     * @return
     */
    public static Human makeHuman(String type){
        if ("man".equals(type)){
            return new Man();
        }else if ("womman".equals(type)){
            return new Womman();
        }else{
            return null;
        }
    }

    /**
     * 利用反射生产
     * @param T
     * @return
     */
    public static Human makeHuman1(Class T){
        Human human = null;
        try {
            human = (Human) Class.forName(T.getName()).newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            System.out.println("不支持抽象类或接口");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("没有足够权限，即不能访问私有对象");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("类不存在");
            e.printStackTrace();
        }
        return human;
    }
}
