package com.gt.wide.mapper;

import com.gt.wide.bean.User;

/**
 * 
 * @author qin
 *
 */
public interface UserMapper {
	User findUserByUsername(String username);
}
