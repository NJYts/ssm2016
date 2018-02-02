package com.atguigu.p2p.service.impl;

import com.atguigu.p2p.dao.UserMapper;
import com.atguigu.p2p.entity.User;
import com.atguigu.p2p.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getByName(String name, String password) {
		User user = userMapper.getByName(name);
		if(user != null
				&& user.getEnabled() == 1
				&& user.getPassword().equals(password)){
			return user;
		}
		return null;
	}
}
