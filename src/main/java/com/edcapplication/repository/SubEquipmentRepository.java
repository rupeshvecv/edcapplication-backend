package com.edcapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edcapplication.model.SubEquipment;

@Repository
public interface SubEquipmentRepository extends CrudRepository<SubEquipment, Integer> {

}


