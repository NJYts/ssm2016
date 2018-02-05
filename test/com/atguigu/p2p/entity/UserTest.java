package com.atguigu.p2p.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/** 
* User Tester. 
* 
* @author <Authors name> 
* @since <pre>二月 5, 2018</pre> 
* @version 1.0 
*/ 
public class UserTest { 

@Before

public void before() throws Exception {
	System.out.println("before");
} 

@After
public void after() throws Exception {
	System.out.println("after");
}
	@Parameterized.Parameters
	public static Collection<Object[]> t() {
		return Arrays.asList(new Object[][]{
				{3,1,2},
				{5,2,3}
		});
	}
	@Test
	public void testAdd()
	{
		System.out.println("test");
		User user = new User();
		int result = 4;
		Collection<Object[]> t = UserTest.t();
		// 判断方法的返回结果
		//Assert.assertEquals(3, result);// 第一个参数是期望值，第二个参数是要验证的值
		for (Object[] obj:t) {
			System.out.println(obj[0].toString()+obj[1].toString()+obj[2].toString());
		}

	}



	/**
* 
* Method: getName() 
* 
*/ 
@Test

public void testGetName() throws Exception {
//TODO: Test goes here... 
} 

/** 
* 
* Method: setName(String name) 
* 
*/ 
@Test

public void testSetName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getPassword() 
* 
*/ 
@Test
public void testGetPassword() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setPassword(String password) 
* 
*/ 
@Test
public void testSetPassword() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getEnabled() 
* 
*/ 
@Test
public void testGetEnabled() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setEnabled(int enabled) 
* 
*/ 
@Test
public void testSetEnabled() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSalt() 
* 
*/ 
@Test
public void testGetSalt() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setSalt(String salt) 
* 
*/ 
@Test
public void testSetSalt() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getRole() 
* 
*/ 
@Test
public void testGetRole() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setRole(Role role) 
* 
*/ 
@Test
public void testSetRole() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getRoleList() 
* 
*/ 
@Test
public void testGetRoleList() throws Exception { 
//TODO: Test goes here... 
} 


} 
