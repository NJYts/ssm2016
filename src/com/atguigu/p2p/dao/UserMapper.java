package com.atguigu.p2p.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.atguigu.p2p.entity.User;
@Repository
public interface UserMapper {

	User getByName(@Param("name") String name);
	
}
