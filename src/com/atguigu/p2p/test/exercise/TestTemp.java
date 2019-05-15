package com.atguigu.p2p.test.exercise;

import java.lang.reflect.Field;

/**
   *    @author  : niujianye
   *    @time    : 2018/3/27 9:44
   *    @description : 反射实现ab值得互换
   *    getFields()只能获取public的字段，包括父类的。
　　     而getDeclaredFields()只能获取自己声明的各种字段，包括public，protected，private。
		再来获取此类中的所有字段
		Field[] fields = User.class.getDeclaredFields();
		获取字段的名称

		String fieldName = field.getName();

		获取字段的修饰符

		int fieldValue = field.getModifiers();//如：private、static、final等

		与某个具体的修饰符进行比较

		Modifier.isStatic(fieldValue)//看此修饰符是否为静态(static)

		获取字段的声明类型

		field.getType()；//返回的是一个class

		与某个类型进行比较

		field.getType() == Timestamp.class

		获取指定对象中此字段的值

		Object fieldObject= field.get(user);//user可以看做是从数据库中查找出来的对象
		
   *    @param :  * @param null
   *    @version : v2.0
   *
   * Created by WISE on 2018/3/26.
 */
public class TestTemp {
	public static void main(String[] args) {
		Integer a=1,b=2;
		swap(a,b);
		System.out.println("a:"+a);
		System.out.println("b:"+b);
	}

	public static void swap(Integer i1,Integer i2){
		Field field = null;
		try {
			field = Integer.class.getDeclaredField("value");
			field.setAccessible(true);//对属性设置访问权限
			Integer tmp = new Integer(i1);
			field.set(i1,i2);
			field.set(i2,tmp);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
