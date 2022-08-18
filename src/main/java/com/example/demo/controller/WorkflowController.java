package com.example.demo.controller;

import java.sql.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Workflow;
import com.example.demo.repository.WorkflowRepository;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class WorkflowController {

	@Autowired
	private WorkflowRepository workflowRepository;

	@PutMapping("workflow/{id_wf}/update")
	public ResponseEntity<Workflow> updatePost(@PathVariable Long id_wf,
			@RequestParam("wf_from") Time wf_from, 
			@RequestParam("wf_to") Time wf_to,
			@RequestParam("statut") String statut) {

		Workflow workflow = workflowRepository.findById(id_wf).orElseThrow();
		workflow.setWf_from(wf_from);
		workflow.setWf_to(wf_to);
		workflow.setStatut(statut);

		Workflow updatedworkflow = workflowRepository.save(workflow);
		return ResponseEntity.ok(updatedworkflow);
	}

}
