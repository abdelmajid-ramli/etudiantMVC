package com.example.sec.service;

import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sec.entities.AppRole;
import com.example.sec.entities.AppUser;
import com.example.sec.repositories.AppRoleRepository;
import com.example.sec.repositories.AppUserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImp implements SecurityService{
	private AppUserRepository appUserRepository;
	private AppRoleRepository appRoleRepository;
	private PasswordEncoder passwordEncoder;

	@Override
	public AppUser saveNewUser(String username, String password, String rePassword) {
		if(!password.equals(rePassword)) throw new RuntimeException("password does not match");
		String hashedPWD=passwordEncoder.encode(password);
		AppUser appUser=new AppUser();
		appUser.setUserId(UUID.randomUUID().toString());
		appUser.setUsername(username);
		appUser.setPassword(password);
		appUser.setActive(true);
		AppUser savedAppUser=appUserRepository.save(appUser);
		return savedAppUser;
	}

	@Override
	public AppRole saveNewRole(String roleName, String description) {
		AppRole appRole=appRoleRepository.findByRoleName(roleName);
		if(appRole!=null) throw new RuntimeException("role "+roleName+" already exist");
		appRole=new AppRole();
		appRole.setRoleName(roleName);
		appRole.setDescription(description);
		
		AppRole savedAppRole=appRoleRepository.save(appRole);
		return savedAppRole;
	}
	
	@Override
	public void addRoletoUser(String username, String roleName) {
		AppUser appUser=appUserRepository.findByUsername(username);
		if(appUser!=null) throw new RuntimeException("user not found");
		AppRole appRole=appRoleRepository.findByRoleName(roleName);
		if(appRole!=null) throw new RuntimeException("role not found");
		appUser.getAppRoles().add(appRole);
		appUserRepository.save(appUser);
	}

	@Override
	public void removeRoleFromUser(String username, String roleName) {
		AppUser appUser=appUserRepository.findByUsername(username);
		if(appUser!=null) throw new RuntimeException("user not found");
		AppRole appRole=appRoleRepository.findByRoleName(roleName);
		if(appRole!=null) throw new RuntimeException("role not found");
		appUser.getAppRoles().remove(appRole);
		appUserRepository.save(appUser);
	}

	@Override
	public AppUser loadUserByUserName(String username) {
		
		return appUserRepository.findByUsername(username);
	}

}
