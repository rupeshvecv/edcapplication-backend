package com.edcapplication.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="project_table", schema="edcapplication") 
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name= "project_code")
	private String projectCode;

	@Column(name= "description")
	private String description;
	
	@Column(name= "status")
	private String status;
	
	@Column(name = "project_owner")
	private Integer userId;
	
	
	@Column(name= "project_start_date")
	private LocalDate projectStartDate;
	
	@Column(name= "project_end_date")
	private LocalDate projectEndDate;
	
	public Project() {
		super();
	}

	public Project(int id, String projectCode, String description, String status, Integer userId,
			LocalDate projectStartDate, LocalDate projectEndDate) {
		super();
		this.id = id;
		this.projectCode = projectCode;
		this.description = description;
		this.status = status;
		this.userId = userId;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDate getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(LocalDate projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public LocalDate getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(LocalDate projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectCode=" + projectCode+ ", description=" + description+ ", status=" + status+ ", userId=" + userId+ ", projectStartDate=" + projectStartDate+ ", projectEndDate=" + projectEndDate +"]";
	}
	
	
}
