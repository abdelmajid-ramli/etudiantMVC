package com.example;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.sec.service.SecurityService;
import com.example.entities.Etudiant;
import com.example.entities.Genre;
import com.example.repositories.EtudiantRepository;

@SpringBootApplication
public class EtudiantMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantMvcApplication.class, args);
		System.out.println("hii");
	}
	
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CommandLineRunner cmdRunner(EtudiantRepository etudiantRep) {
		return args -> {
			etudiantRep.save(new Etudiant(null,"ali","ahmed","ali@email.com",new Date(),Genre.MASCULAN,true));
			etudiantRep.save(new Etudiant(null,"khalid","alaoui","khalid@email.com",new Date(),Genre.MASCULAN,true));
			etudiantRep.save(new Etudiant(null,"samir","hadadi","samir@email.com",new Date(),Genre.MASCULAN,true));
			etudiantRep.save(new Etudiant(null,"ahlam","hanae","ahlam@email.com",new Date(),Genre.MASCULAN,true));
			etudiantRep.save(new Etudiant(null,"james","marke","james@email.com",new Date(),Genre.MASCULAN,true));
			
			etudiantRep.findAll().forEach(p->{
				System.out.println(p.getNom());
			});
		};
	}
	
	//@Bean
	public CommandLineRunner saveUsers(SecurityService securityService) {
		return args -> {
			//securityService.saveNewUser("ahmed", "1234", "1234");
			securityService.saveNewUser("ali", "1234", "1234");
			//securityService.saveNewUser("khalid", "1234", "1234");
			
			securityService.saveNewRole("USER", "");
			securityService.saveNewRole("ADMIN", "");
			
			
			//securityService.addRoletoUser("ahmed", "USER");
			//securityService.addRoletoUser("ahmed", "ADMIN");
			//securityService.addRoletoUser("ali", "USER");
			//securityService.addRoletoUser("khalid", "ADMIN");
		};
	}
	

}
