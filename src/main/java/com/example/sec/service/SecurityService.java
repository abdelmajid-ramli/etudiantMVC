package com.example.sec.service;

import com.example.sec.entities.AppRole;
import com.example.sec.entities.AppUser;

public interface SecurityService {
	AppUser saveNewUser(String username,String password, String rePassword);
	AppRole saveNewRole(String roleName, String description);
	void addRoletoUser(String username,String roleName);
	void removeRoleFromUser(String username,String roleName);
	AppUser loadUserByUserName(String username);
}
