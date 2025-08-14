package com.edcapplication.dao;

public class SubEquipmentDao {
    private int id;
    private String subequipmentName;
    private int equipmentId;

    public SubEquipmentDao() {}

    public SubEquipmentDao(int id, String subequipmentName, int equipmentId) {
        this.id = id;
        this.subequipmentName = subequipmentName;
        this.equipmentId = equipmentId;
    }

    public int getId() {
        return id;
    }

    public String getSubequipmentName() {
        return subequipmentName;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubequipmentName(String subequipmentName) {
        this.subequipmentName = subequipmentName;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }
}
