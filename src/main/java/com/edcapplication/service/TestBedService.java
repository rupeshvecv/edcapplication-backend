package com.edcapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edcapplication.model.TestBed;
import com.edcapplication.repository.TestBedRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TestBedService {

private TestBedRepository testBedRepository;
	
	public TestBedService(TestBedRepository testBedRepository) {
		this.testBedRepository = testBedRepository;
	}
	
	public List<TestBed> getAllTestBeds() {
		return (List<TestBed>) testBedRepository.findAll();
		
		/*
		 * List<TestBed> testBeds = (List<TestBed>) testBedRepository.findAll();
		 * testBeds.forEach(tb -> tb.getBdrrEntries().size());
		 *return testBeds;
		 */
		
		//return testBedRepository.findAll();
	}
	
	/*public TestBed getTestBedById(Integer id) {
		Optional<TestBed> TestBedResponse =  testBedRepository.findById(id);
		TestBed TestBed = TestBedResponse.get();
		return TestBed;
	}*/
	
	public TestBed getTestBedById(int id) {
        return testBedRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestBed not found with ID: " + id));
    }
	
	public TestBed addTestBed(TestBed testBed) {
		/*
		 * testBed.setId(0); if (testBed.getBdrrEntries() != null) {
		 * testBed.getBdrrEntries().forEach(entry -> entry.setTestBed(testBed)); }
		 * return testBedRepository.save(testBed);
		 */
		return testBedRepository.save(testBed);
	}
	
	//Update an existing TestBed
    public TestBed updateTestBed(int id, TestBed updatedTestBed) {
        TestBed existing = testBedRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestBed not found with ID: " + id));

        existing.setName(updatedTestBed.getName());

		/*
		 * //Update bdrrEntries safely if (updatedTestBed.getBdrrEntries() != null) { //
		 * Remove old ones existing.getBdrrEntries().clear();
		 * 
		 * // Add new ones and link back updatedTestBed.getBdrrEntries().forEach(entry
		 * -> entry.setTestBed(existing));
		 * existing.getBdrrEntries().addAll(updatedTestBed.getBdrrEntries()); }
		 */

        return testBedRepository.save(existing);
    }
    
	public void deleteTestBed(int id) {
        if (!testBedRepository.existsById(id)) {
            throw new EntityNotFoundException("TestBed not found with ID: " + id);
        }
        testBedRepository.deleteById(id);
    }
}
