package com.edcapplication.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.edcapplication.dao.TestBedEntryDao;
import com.edcapplication.model.Project;
import com.edcapplication.model.TestBed;
import com.edcapplication.model.TestBedEntry;
import com.edcapplication.model.TestBedEntryEmbeddedId;
import com.edcapplication.repository.ProjectRepository;
import com.edcapplication.repository.TestBedEntryRepository;
import com.edcapplication.repository.TestBedRepository;

@Service
public class TestBedEntryService {

    private final TestBedEntryRepository testBedEntryRepository;
    private final TestBedRepository testBedRepository;
    private final ProjectRepository projectRepository;

    public TestBedEntryService(TestBedEntryRepository testBedEntryRepository,
                               TestBedRepository testBedRepository,
                               ProjectRepository projectRepository) {
        this.testBedEntryRepository = testBedEntryRepository;
        this.testBedRepository = testBedRepository;
        this.projectRepository = projectRepository;
    }

    public List<TestBedEntry> getAllTestBedEntries() {
        return testBedEntryRepository.findAll();
    }

    public TestBedEntry getTestBedEntryById(TestBedEntryEmbeddedId id) {
        return testBedEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TestBedEntry not found for id: " + id));
    }

    public TestBedEntry createTestBedEntry(TestBedEntryDao dao) {
        TestBed testBed = testBedRepository.findById(dao.getTestbedId())
                .orElseThrow(() -> new RuntimeException("TestBed not found"));
        Project project = projectRepository.findById(dao.getProjectId())
                .orElse(null); // project is optional

        TestBedEntry entry = new TestBedEntry();
        entry.setId(new TestBedEntryEmbeddedId(dao.getTestbedId(), dao.getRaisedOn(), dao.getShift()));
        entry.setTime(dao.getTime());
        entry.setRaisedBy(dao.getRaisedBy());
        entry.setTestBedUser(dao.getTestBedUser());
        entry.setProject(project);
        entry.setPlannedHours(dao.getPlannedHours());
        entry.setUptimeHours(dao.getUptimeHours());
        entry.setUtilizationHours(dao.getUtilizationHours());
        entry.setValidationHours(dao.getValidationHours());
        entry.setRunningInRemarks(dao.getRunningInRemarks());
        entry.setRunningInHours(dao.getRunningInHours());
        entry.setSetUpRemarks(dao.getSetUpRemarks());
        entry.setSetUpHours(dao.getSetUpHours());
        entry.setWorkonEngineRemarks(dao.getWorkonEngineRemarks());
        entry.setWorkonEngineHours(dao.getWorkonEngineHours());
        entry.setBreakDownRemarks(dao.getBreakDownRemarks());
        entry.setBreakDownHours(dao.getBreakDownHours());
        entry.setNoManPowerRemarks(dao.getNoManPowerRemarks());
        entry.setNoManPowerHours(dao.getNoManPowerHours());
        entry.setAnyOtherRemarks(dao.getAnyOtherRemarks());
        entry.setAnyOtherHours(dao.getAnyOtherHours());
        entry.setTotalSum(dao.getTotalSum());
        entry.setEngineChangeoverTime(dao.getEngineChangeoverTime());

        return testBedEntryRepository.save(entry);
    }

    public TestBedEntry updateTestBedEntry(TestBedEntryDao dao) {
        TestBedEntryEmbeddedId id = new TestBedEntryEmbeddedId(dao.getTestbedId(), dao.getRaisedOn(), dao.getShift());
        TestBedEntry existing = testBedEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TestBedEntry not found for update"));

        Project project = projectRepository.findById(dao.getProjectId())
                .orElse(null); // optional

        existing.setTime(dao.getTime());
        existing.setRaisedBy(dao.getRaisedBy());
        existing.setTestBedUser(dao.getTestBedUser());
        existing.setProject(project);
        existing.setPlannedHours(dao.getPlannedHours());
        existing.setUptimeHours(dao.getUptimeHours());
        existing.setUtilizationHours(dao.getUtilizationHours());
        existing.setValidationHours(dao.getValidationHours());
        existing.setRunningInRemarks(dao.getRunningInRemarks());
        existing.setRunningInHours(dao.getRunningInHours());
        existing.setSetUpRemarks(dao.getSetUpRemarks());
        existing.setSetUpHours(dao.getSetUpHours());
        existing.setWorkonEngineRemarks(dao.getWorkonEngineRemarks());
        existing.setWorkonEngineHours(dao.getWorkonEngineHours());
        existing.setBreakDownRemarks(dao.getBreakDownRemarks());
        existing.setBreakDownHours(dao.getBreakDownHours());
        existing.setNoManPowerRemarks(dao.getNoManPowerRemarks());
        existing.setNoManPowerHours(dao.getNoManPowerHours());
        existing.setAnyOtherRemarks(dao.getAnyOtherRemarks());
        existing.setAnyOtherHours(dao.getAnyOtherHours());
        existing.setTotalSum(dao.getTotalSum());
        existing.setEngineChangeoverTime(dao.getEngineChangeoverTime());

        return testBedEntryRepository.save(existing);
    }

    public void deleteTestBedEntry(TestBedEntryEmbeddedId id) {
        if (!testBedEntryRepository.existsById(id)) {
            throw new RuntimeException("TestBed Entry not found with ID: " + id);
        }
        testBedEntryRepository.deleteById(id);
    }
}
