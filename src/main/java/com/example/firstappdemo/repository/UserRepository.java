package com.example.firstappdemo.repository;

import com.example.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xuhh
 * {@link  User}{@link Repository}
 * @Date: Created in 19:24 2019/1/9
 * @Modified By:
 */
@Repository
public class UserRepository {
	/**
	 *才有内存型的存储方式->Map
	 */
	private final ConcurrentMap<Integer,User> repository
			= new ConcurrentHashMap<>();
	//id生成器
	private final static AtomicInteger idGenerator =
			new AtomicInteger();
	/**
	 *
	 * @Description:
	 * 
	 * @auther: xuhh
	 * @date: 19:32 2019/1/9 
	 * @param: [user] {@link  User}{
	 * @return: boolean   如果保存成功，返回true
	 * 否则为false
	 */
	public boolean save(User user){
		//ID 从1开始
		Integer id =idGenerator.incrementAndGet();
		user.setId(id);
		return repository.put(id,user) ==null;

	}
}
