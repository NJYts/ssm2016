package com.atguigu.p2p.test.exercise;

/**
 * Created by WISE on 2018/3/1.
 */
import java.lang.reflect.ParameterizedType;

import java.lang.reflect.Type;

public class Student extends Persons {

	public static void main(String[] args) {

		Student stu=new Student();

		Class clazz=stu.getClass();

		System.out.println(clazz);

		Type type = stu.getClass().getGenericSuperclass();

		System.out.println(type);

// 强转为“参数化类型”

//ParameterizedType参数化类型，即泛型

		ParameterizedType pt = (ParameterizedType) type; // BaseDao

// 获取参数化类型中，实际类型的定义

		Type[] ts = pt.getActualTypeArguments();

// 转换

		Class c= (Class) ts[0];

		System.out.println(c);

	}

}
