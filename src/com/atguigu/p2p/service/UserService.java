package com.atguigu.p2p.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.p2p.dao.UserMapper;
import com.atguigu.p2p.entity.User;


public interface UserService {

	public User getByName(String name, String password);
}
