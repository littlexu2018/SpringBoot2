package com.example.firstappdemo.controller;

import com.example.firstappdemo.domain.User;
import com.example.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xuhh
 * @Description:
 * @Date: Created in 19:40 2019/1/9
 * @Modified By:
 */
@RestController
public class UserController {

	private  final UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/peroson/save")
	public User save(@RequestParam  String name){
		User user = new User();
		user.setName(name);
		if(userRepository.save(user)){
			System.out.format("用户对象"+user);
		}
		return user;

	}
}
