package com.etip.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etip.app.entity.User;
import com.etip.app.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

	@Autowired
    private UserRepository userRepository;
	
	@GetMapping("api/auth/user/username")
	public Optional<User> findByUserName(@RequestParam String name) {
		return userRepository.findByUserName(name);
	}
	
	@GetMapping("api/auth/user/findAll")
	public Flux<User> findAll() {
		return userRepository.findAll();
	}
	
	@GetMapping("api/auth/user/Id")
	public Mono<User> findById(@RequestParam String id) {
		return userRepository.findById(id);
	}
	
	@DeleteMapping("api/auth/user/delById")
	public Mono<Void> deleteById(@RequestParam String id) {
		return userRepository.deleteById(id);
	}
	
	@DeleteMapping("api/auth/user/delAll")
	public Mono<Void> deleteAll() {
		return userRepository.deleteAll();
	}
	
}
