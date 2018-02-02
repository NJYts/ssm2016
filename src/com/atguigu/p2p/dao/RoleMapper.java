package com.atguigu.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.atguigu.p2p.entity.Authority;
import com.atguigu.p2p.entity.Role;
@Repository
public interface RoleMapper {

	void addAuthorities(Role role);
	
	void clearAuthorities(@Param("roleId") Long roleId);
	
	List<Authority> getParentAuthorities();
	
	Role getById(@Param("id") Long id);
	
}
