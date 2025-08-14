package com.edcapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edcapplication.dao.ProblemDao;
import com.edcapplication.model.Problem;
import com.edcapplication.service.ProblemService;

@RestController
@CrossOrigin
@RequestMapping("/api/edcapplication")
public class ProblemController {

	@Autowired
	ProblemService problemService;
	
	@GetMapping("/problems")
	 public List<ProblemDao> getAllProblems() {
        return problemService.getAllProblems();
    }
	/*
	 * public List<Problem> getProblems() { return problemService.getProblems(); }
	 */
	
	@GetMapping("/problems/{id}")
	public Problem getTeamById(@PathVariable("id") Integer problemId) {
		return problemService.getProblemById(problemId);
	}
	
	@PostMapping(("/problems"))
	/*
	 * public Problem addProblem(@RequestBody Problem problem) { return
	 * problemService.addProblem(problem); }
	 */
	public ProblemDao createProblem(@RequestBody Problem problem) {
        return problemService.addProblem(problem);
    }
	
	@PutMapping(("/problems"))
	public Problem updateProblem(@RequestBody Problem problem) {
        return problemService.updateProblem(problem);
    }
	
	@DeleteMapping("/problems/{id}")
	public void deleteProblem(@PathVariable Integer id) {
		System.out.println("ProblemController.deleteProblem(id) "+id);
		problemService.deleteProblem(id);
    }
}
