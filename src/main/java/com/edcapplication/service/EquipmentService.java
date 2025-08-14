package com.edcapplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.edcapplication.dao.EquipmentDao;
import com.edcapplication.model.Equipment;
import com.edcapplication.repository.EquipmentRepository;

@Service
public class EquipmentService {

private EquipmentRepository equipmentRepository;
	
	public EquipmentService(EquipmentRepository equipmentRepository) {
		this.equipmentRepository = equipmentRepository;
	}
	
	/*
	 * public List<Equipment> getEquipments() { return (List<Equipment>)
	 * equipmentRepository.findAll(); }
	 */
	
	 public List<EquipmentDao> getAllEquipments() {
	        List<Equipment> equipments = (List<Equipment>) equipmentRepository.findAll();
	        return equipments.stream()
	                .map(e -> new EquipmentDao(e.getId(), e.getEquipmentName()))
	                .collect(Collectors.toList());
	    }
	
		/*
		 * public Equipment getEquipmentById(Integer id) { Optional<Equipment>
		 * EquipmentResponse = equipmentRepository.findById(id); Equipment Equipment =
		 * EquipmentResponse.get(); return Equipment; }
		 */
	 
	 public EquipmentDao getEquipmentById(int id) {
	        Equipment equipment = equipmentRepository.findById(id).orElse(null);
	        if (equipment == null) return null;
	        return new EquipmentDao(equipment.getId(), equipment.getEquipmentName());
	    }
	
	/*
	 * public Equipment addEquipment(Equipment equipment) { Equipment equipment1 =
	 * equipmentRepository.save(equipment); return equipment1; }
	 */
	
	public EquipmentDao addEquipment(Equipment equipment) {
        Equipment saved = equipmentRepository.save(equipment);
        return new EquipmentDao(saved.getId(), saved.getEquipmentName());
    }
	
	public Equipment updateEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }
	
	public void deleteEquipment(Integer id) {
		equipmentRepository.deleteById(id);
	}
}
