package com.edcapplication.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="testbed_table") 
public class TestBed {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy = "testBed", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BDRREntry> bdrrEntries;
	
	@Column(name= "testbed_name")
	private String name;

	public TestBed() {
		super();
	}

	public TestBed(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<BDRREntry> getBdrrEntries() {
		return bdrrEntries;
	}

	public void setBdrrEntries(List<BDRREntry> bdrrEntries) {
		this.bdrrEntries = bdrrEntries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestBed [id=" + id + ", name=" + name +"]";
	}
}
