package com.example.sec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sec.entities.AppRole;


public interface AppRoleRepository extends JpaRepository<AppRole,Long>{
	AppRole findByRoleName(String  roleName);
}
