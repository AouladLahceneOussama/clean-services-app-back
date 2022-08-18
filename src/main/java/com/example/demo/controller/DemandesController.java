package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Demandes;
import com.example.demo.repository.DemandesRepository;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class DemandesController {
	@Autowired
	private DemandesRepository DemandesRepository;

	// get all demandd
	@GetMapping("demands")
	public List<Demandes> getAllDemands() {
		return DemandesRepository.findAll();
	}

	@PostMapping("demands/add")
	public Demandes AddDemand(@RequestBody Demandes demand) {
		return DemandesRepository.save(demand);
	}

	@GetMapping("demands/{id}/{date}")
	public ResponseEntity<List<Demandes>> getDemandbyDateetId(@PathVariable String id, @PathVariable Date date) {
		List<Demandes> Demandes = DemandesRepository.getDemandbyDate(date, id);
		return ResponseEntity.ok(Demandes);
	}

	// get in progress demande by employee id
	@GetMapping("demands/{id}")
	public List<Demandes> getInProgressDemands(@PathVariable String id) {
		List<Demandes> Demandes = DemandesRepository.getInProgressDemands(id);
		return Demandes;
	}

	// change demand statut
	@PutMapping("demands/update/{id_demande}")
	public void updateStatut(@PathVariable Long id_demande, @RequestParam("statut") String statut) {
		Demandes demande = DemandesRepository.findById(id_demande).orElseThrow();
		System.out.println("statut = " + statut);
		demande.setStatut(statut);
		DemandesRepository.save(demande);
	}

	// get client demands by phineNumber
	@GetMapping("demands/client/{phone}")
	public List<Demandes> getClientDemandes(@PathVariable String phone) {
		return DemandesRepository.getClientDemandes(phone);
	}

	// change demand isDeleted
	@PutMapping("demands/isDeleted/{id_demande}")
	public void updateIsDeleted(@PathVariable Long id_demande) {
		Demandes demande = DemandesRepository.findById(id_demande).orElseThrow();
		demande.setIsDeleted(1);
		DemandesRepository.save(demande);
	}
}
