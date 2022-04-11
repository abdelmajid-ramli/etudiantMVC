package com.example.sec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sec.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,String>{
	AppUser findByUsername(String  username);
}
