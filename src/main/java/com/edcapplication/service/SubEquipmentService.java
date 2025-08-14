package com.edcapplication.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edcapplication.dao.EquipmentDao;
import com.edcapplication.dao.SubEquipmentDao;
import com.edcapplication.model.Equipment;
import com.edcapplication.model.SubEquipment;
import com.edcapplication.repository.EquipmentRepository;
import com.edcapplication.repository.SubEquipmentRepository;

@Service
public class SubEquipmentService {

private SubEquipmentRepository subequipmentRepository;

@Autowired
private EquipmentRepository equipmentRepository;
	
	public SubEquipmentService(SubEquipmentRepository subequipmentRepository) {
		this.subequipmentRepository = subequipmentRepository;
	}
	
	/*
	 * public List<SubEquipment> getSubEquipments() { return (List<SubEquipment>)
	 * subequipmentRepository.findAll(); }
	 */
	 public List<SubEquipmentDao> getAllSubEquipments() {
		 List<SubEquipment> subEquipments = (List<SubEquipment>) subequipmentRepository.findAll();
		 return subEquipments.stream()
				 .map(s -> new SubEquipmentDao(s.getId(), s.getSubequipmentName(), s.getEquipment().getId()))
	                .collect(Collectors.toList());
	 }

	public SubEquipment getSubEquipmentById(Integer id) {
		Optional<SubEquipment> SubEquipmentResponse =  subequipmentRepository.findById(id);
		SubEquipment SubEquipment = SubEquipmentResponse.get();
		return SubEquipment;
	}
	
	/*
	 * public SubEquipmentDao addSubEquipment(SubEquipment s) { SubEquipment saved =
	 * subequipmentRepository.save(s); return new SubEquipmentDao(saved.getId(),
	 * saved.getSubequipmentName(), saved.getEquipment().getId()); }
	 */
	
	public SubEquipmentDao addSubEquipment(SubEquipmentDao dao) {
	    Equipment equipment = equipmentRepository.findById(dao.getEquipmentId())
	                            .orElseThrow(() -> new RuntimeException("Equipment not found"));

	    SubEquipment sub = new SubEquipment();
	    sub.setSubequipmentName(dao.getSubequipmentName());
	    sub.setEquipment(equipment);

	    SubEquipment saved = subequipmentRepository.save(sub);
	    return new SubEquipmentDao(saved.getId(), saved.getSubequipmentName(), equipment.getId());
	}
	/*
	 * public SubEquipment addSubEquipment(SubEquipment subequipment) { SubEquipment
	 * subequipment1 = subequipmentRepository.save(subequipment); return
	 * subequipment1; }
	 */
	
	public SubEquipment updateSubEquipment(SubEquipment subequipment) {
        return subequipmentRepository.save(subequipment);
    }
	
	public void deleteSubEquipment(Integer id) {
		subequipmentRepository.deleteById(id);
	}
}
