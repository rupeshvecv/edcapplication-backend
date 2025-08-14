package com.edcapplication.dao;

public class EquipmentDao {
    private int id;
    private String equipmentName;

    public EquipmentDao() {}

    public EquipmentDao(int id, String equipmentName) {
        this.id = id;
        this.equipmentName = equipmentName;
    }

    public int getId() {
        return id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}
