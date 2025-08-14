package com.edcapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edcapplication.model.BDRREntry;

@Repository
public interface BDRREntryRepository extends JpaRepository<BDRREntry, Integer> {
	
}
