package com.edcapplication.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.edcapplication.dao.EquipmentDao;
import com.edcapplication.dao.ProblemDao;
import com.edcapplication.model.Equipment;
import com.edcapplication.model.Problem;
import com.edcapplication.repository.ProblemRepository;

@Service
public class ProblemService {

private ProblemRepository problemRepository;
	
	public ProblemService(ProblemRepository problemRepository) {
		this.problemRepository = problemRepository;
	}
	
	/*
	 * public List<Problem> getProblems() { return (List<Problem>)
	 * problemRepository.findAll(); }
	 */
	
	public List<ProblemDao> getAllProblems() {
		 List<Problem> problems = (List<Problem>) problemRepository.findAll();
	        return problems.stream()
	                .map(p -> new ProblemDao(p.getId(), p.getProblemName(),p.getEquipment().getId()))
	                .collect(Collectors.toList());
    }
	
	public Problem getProblemById(Integer id) {
		Optional<Problem> ProblemResponse =  problemRepository.findById(id);
		Problem Problem = ProblemResponse.get();
		return Problem;
	}
	
	/*
	 * public Problem addProblem(Problem problem) { Problem problem1 =
	 * problemRepository.save(problem); return problem1; }
	 */
	public ProblemDao addProblem(Problem p) {
        Problem saved = problemRepository.save(p);
        return new ProblemDao(saved.getId(), saved.getProblemName(), saved.getEquipment().getId());
    }
	
	public Problem updateProblem(Problem problem) {
        return problemRepository.save(problem);
    }
	
	public void deleteProblem(Integer id) {
		problemRepository.deleteById(id);
	}
}
