package com.edcapplication.dao;

public class ProblemDao {
    private int id;
    private String problemName;
    private int equipmentId;

    public ProblemDao() {}

    public ProblemDao(int id, String problemName, int equipmentId) {
        this.id = id;
        this.problemName = problemName;
        this.equipmentId = equipmentId;
    }

    public int getId() {
        return id;
    }

    public String getProblemName() {
        return problemName;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }
}
