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

import com.edcapplication.dao.SubEquipmentDao;
import com.edcapplication.model.SubEquipment;
import com.edcapplication.service.SubEquipmentService;

@RestController
@CrossOrigin
@RequestMapping("/api/edcapplication")
public class SubEquipmentController {

	@Autowired
	SubEquipmentService subEquipmentService;
	
	@GetMapping("/subEquipments")
	/*
	 * public List<SubEquipment> getSubEquipments() { return
	 * subEquipmentService.getSubEquipments(); }
	 */
	 public List<SubEquipmentDao> getAllSubEquipments() {
        return subEquipmentService.getAllSubEquipments();
    }
	
	@GetMapping("/subEquipments/{id}")
	public SubEquipment getTeamById(@PathVariable("id") Integer subEquipmentId) {
		return subEquipmentService.getSubEquipmentById(subEquipmentId);
	}
	
	@PostMapping(("/subEquipments"))
	/*
	 * public SubEquipment addSubEquipment(@RequestBody SubEquipment subEquipment) {
	 * return subEquipmentService.addSubEquipment(subEquipment); }
	 */
	public SubEquipmentDao createSubEquipment(@RequestBody SubEquipmentDao subEquipmentDao) {
        return subEquipmentService.addSubEquipment(subEquipmentDao);
    }
	
	@PutMapping(("/subEquipments"))
	public SubEquipment updateSubEquipment(@RequestBody SubEquipment subEquipment) {
        return subEquipmentService.updateSubEquipment(subEquipment);
    }
	
	@DeleteMapping("/subEquipments/{id}")
	public void deleteSubEquipment(@PathVariable Integer id) {
		System.out.println("SubEquipmentController.deleteSubEquipment(id) "+id);
		subEquipmentService.deleteSubEquipment(id);
    }
}
