package com.example.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.Etudiant;
import com.example.repositories.EtudiantRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EtudiantController {
	private EtudiantRepository etudiantRep;
	/*
	
	@GetMapping(path="/user/index")
	public String patients(Model model,
						   @RequestParam(name = "page",defaultValue = "0") int page,
						   @RequestParam(name = "size",defaultValue = "5") int size,
						   @RequestParam(name = "keyword",defaultValue = "") String keyword) {
		Page<Etudiant> etudiantsPage=etudiantRep.findByNomContains(keyword,PageRequest.of(page, size));
		model.addAttribute("listEtudiant",etudiantsPage.getContent());
		model.addAttribute("pages",new int[etudiantsPage.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("keyword",keyword);
		return "etudiants";
	}
	
	@GetMapping(path="/admin/delete")
	public String deletePatient(Model model,@RequestParam(name = "id",defaultValue = "0") Long id,
			   				@RequestParam(name = "page",defaultValue = "0") int page,
			   				@RequestParam(name = "keyword",defaultValue = "")String keyword) {
		etudiantRep.deleteById(id);
		return "redirect:/user/index?page="+page+"&keyword="+keyword;
	}
	
    @GetMapping( "/")
    public String home(){
        return "home";
    }
	
	@GetMapping(path="/etudiants")
	@ResponseBody
	public List<Etudiant> Patients() {
		return etudiantRep.findAll();
	}
	
	@GetMapping(path="/admin/formEtudiant")
	public String formPatient(Model model) {
		
		model.addAttribute("etudiant",new Etudiant());
		
		return "formEtudiant";
	}
	
	@PostMapping(path="/amdin/save")
	public String save(Model model,@Valid Etudiant etudiant, BindingResult bindingResult,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String keyword) {
		
		if(bindingResult.hasErrors()) {
			return "formEtudiant";
		}
		etudiantRep.save(etudiant);
		
		return "redirect:/user/index?page="+page+"&keyword="+keyword;
	}
	
	@GetMapping(path="/admin/editEtudiant")
	public String editEtudiant(Model model,Long id,int page,String keyword) {
		Etudiant etudiant=etudiantRep.findById(id).orElse(null);
		if(etudiant==null) {
		throw new RuntimeException("etudiant n'existe pas");
		}
		model.addAttribute("etudiant",etudiant);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		
		return "editEtudiant";
	}*/
	

}
