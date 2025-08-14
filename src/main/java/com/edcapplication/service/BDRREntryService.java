package com.edcapplication.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edcapplication.dao.BDRREntryDao;
import com.edcapplication.model.BDRREntry;
import com.edcapplication.model.Equipment;
import com.edcapplication.model.Problem;
import com.edcapplication.model.SubEquipment;
import com.edcapplication.model.TestBed;
import com.edcapplication.repository.BDRREntryRepository;
import com.edcapplication.repository.EquipmentRepository;
import com.edcapplication.repository.ProblemRepository;
import com.edcapplication.repository.SubEquipmentRepository;
import com.edcapplication.repository.TestBedRepository;

@Service
public class BDRREntryService {

    @Autowired
    private BDRREntryRepository bdrrEntryRepository;

    @Autowired
    private TestBedRepository testBedRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private SubEquipmentRepository subEquipmentRepository;

    @Autowired
    private ProblemRepository problemRepository;

    public List<BDRREntry> getBDRREntries() {
        return bdrrEntryRepository.findAll();
    }

    public BDRREntry getBDRREntryById(Integer id) {
        return bdrrEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BDRR Entry not found with ID: " + id));
    }

    public BDRREntry createBDRREntry(BDRREntryDao dao) {
        TestBed testBed = testBedRepository.findById(dao.getTestbedId())
                .orElseThrow(() -> new RuntimeException("TestBed not found"));
        Equipment equipment = equipmentRepository.findById(dao.getEquipmentId())
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
        SubEquipment subEquipment = subEquipmentRepository.findById(dao.getSubEquipmentId())
                .orElseThrow(() -> new RuntimeException("SubEquipment not found"));
        Problem problem = problemRepository.findById(dao.getProblemId())
                .orElseThrow(() -> new RuntimeException("Problem not found"));

        BDRREntry entry = new BDRREntry();
        entry.setBdrrNumber(dao.getBdrrNumber());
        entry.setStatus(dao.getStatus());
        entry.setRaisedOn(dao.getRaisedOn());
        entry.setRaisedBy(dao.getRaisedBy());
        entry.setShift(dao.getShift());
        entry.setTestBed(testBed);
        entry.setEquipment(equipment);
        entry.setSubEquipment(subEquipment);
        entry.setProblem(problem);
        entry.setTestAffected(dao.getTestAffected());
        entry.setAlternateArrangement(dao.getAlternateArrangement());
        entry.setSuggestion(dao.getSuggestion());
        entry.setAttender(dao.getAttender());
        entry.setSolutionRootCause(dao.getSolutionRootCause());
        entry.setSolutionActionTaken(dao.getSolutionActionTaken());
        entry.setSolutionBy(dao.getSolutionBy());
        entry.setSolutionGivenOn(dao.getSolutionGivenOn());
        entry.setBdrrOfDate(dao.getBdrrOfDate());
        entry.setAreaAttender(dao.getAreaAttender());
        entry.setTargetDate(dao.getTargetDate());
        entry.setClosingDate(dao.getClosingDate());
        entry.setPartUsed(dao.getPartUsed());
        entry.setPartNumber(dao.getPartNumber());
        entry.setPartDescriptions(dao.getPartDescriptions());
        entry.setQuantity(dao.getQuantity());
        entry.setBreakDownDescription(dao.getBreakDownDescription());
        entry.setInitialAnalysis(dao.getInitialAnalysis());
        entry.setWorkDoneDescription(dao.getWorkDoneDescription());

        return bdrrEntryRepository.save(entry);
    }

    public BDRREntry updateBDRREntry(Integer id, BDRREntryDao dao) {
        BDRREntry existing = getBDRREntryById(id);

        TestBed testBed = testBedRepository.findById(dao.getTestbedId())
                .orElseThrow(() -> new RuntimeException("TestBed not found"));
        Equipment equipment = equipmentRepository.findById(dao.getEquipmentId())
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
        SubEquipment subEquipment = subEquipmentRepository.findById(dao.getSubEquipmentId())
                .orElseThrow(() -> new RuntimeException("SubEquipment not found"));
        Problem problem = problemRepository.findById(dao.getProblemId())
                .orElseThrow(() -> new RuntimeException("Problem not found"));

        existing.setBdrrNumber(dao.getBdrrNumber());
        existing.setStatus(dao.getStatus());
        existing.setRaisedOn(dao.getRaisedOn());
        existing.setRaisedBy(dao.getRaisedBy());
        existing.setShift(dao.getShift());
        existing.setTestBed(testBed);
        existing.setEquipment(equipment);
        existing.setSubEquipment(subEquipment);
        existing.setProblem(problem);
        existing.setTestAffected(dao.getTestAffected());
        existing.setAlternateArrangement(dao.getAlternateArrangement());
        existing.setSuggestion(dao.getSuggestion());
        existing.setAttender(dao.getAttender());
        existing.setSolutionRootCause(dao.getSolutionRootCause());
        existing.setSolutionActionTaken(dao.getSolutionActionTaken());
        existing.setSolutionBy(dao.getSolutionBy());
        existing.setSolutionGivenOn(dao.getSolutionGivenOn());
        existing.setBdrrOfDate(dao.getBdrrOfDate());
        existing.setAreaAttender(dao.getAreaAttender());
        existing.setTargetDate(dao.getTargetDate());
        existing.setClosingDate(dao.getClosingDate());
        existing.setPartUsed(dao.getPartUsed());
        existing.setPartNumber(dao.getPartNumber());
        existing.setPartDescriptions(dao.getPartDescriptions());
        existing.setQuantity(dao.getQuantity());
        existing.setBreakDownDescription(dao.getBreakDownDescription());
        existing.setInitialAnalysis(dao.getInitialAnalysis());
        existing.setWorkDoneDescription(dao.getWorkDoneDescription());

        return bdrrEntryRepository.save(existing);
    }

    public void deleteBDRREntry(Integer id) {
        if (!bdrrEntryRepository.existsById(id)) {
            throw new RuntimeException("BDRR Entry not found with ID: " + id);
        }
        bdrrEntryRepository.deleteById(id);
    }
}
