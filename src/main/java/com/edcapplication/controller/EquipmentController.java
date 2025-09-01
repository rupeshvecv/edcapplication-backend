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

import com.edcapplication.dao.EquipmentDao;
import com.edcapplication.model.Equipment;
import com.edcapplication.service.EquipmentService;

@RestController
@CrossOrigin
@RequestMapping("/api/edcapplication")
public class EquipmentController {

	@Autowired
	EquipmentService equipmentService;
	
	/*
	 * @GetMapping("/equipments") public List<Equipment> getEquipments() { return
	 * equipmentService.getEquipments(); }
	 */

	@GetMapping("/equipments")
    public List<EquipmentDao> getEquipments() {
        return equipmentService.getAllEquipments();
    }
	
	@GetMapping("/equipments/{id}")
	/*
	 * public Equipment getTeamById(@PathVariable("id") Integer equipmentId) {
	 * return equipmentService.getEquipmentById(equipmentId); }
	 */
    public EquipmentDao getEquipmentById(@PathVariable int id) {
        return equipmentService.getEquipmentById(id);
    }
	
	@PostMapping(("/equipments"))
	public EquipmentDao createEquipment(@RequestBody Equipment equipment) {
        return equipmentService.addEquipment(equipment);
    }
	/*
	 * public Equipment addEquipment(@RequestBody Equipment equipment) { return
	 * equipmentService.addEquipment(equipment); }
	 */
	
	@PutMapping(("/equipments"))
	public Equipment updateEquipment(@RequestBody Equipment equipment) {
        return equipmentService.updateEquipment(equipment);
    }
	
	@DeleteMapping("/equipments/{id}")
	public void deleteEquipment(@PathVariable Integer id) {
		System.out.println("EquipmentController.deleteEquipment(id) "+id);
		equipmentService.deleteEquipment(id);
    }
}
