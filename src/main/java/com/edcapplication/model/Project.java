package com.edcapplication.model;

import java.time.LocalDate;

import com.empoweredge.model.User;

import jakarta.persistence.*;

@Entity
@Table(name = "project_table", schema = "edcapplication")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "project_code")
    private String projectCode;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(
        name = "project_owner",
        referencedColumnName = "id",
        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT) //don’t auto-generate FK
    )
    private User projectOwner;
    
    @Column(name = "project_start_date")
    private LocalDate projectStartDate;

    @Column(name = "project_end_date")
    private LocalDate projectEndDate;

    public Project() {}

    public Project(int id, String projectCode, String description, String status, 
                   User projectOwner, LocalDate projectStartDate, LocalDate projectEndDate) {
        this.id = id;
        this.projectCode = projectCode;
        this.description = description;
        this.status = status;
        this.projectOwner = projectOwner;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
    }

    //getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProjectCode() { return projectCode; }
    public void setProjectCode(String projectCode) { this.projectCode = projectCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public User getProjectOwner() { return projectOwner; }
    public void setProjectOwner(User projectOwner) { this.projectOwner = projectOwner; }

    public LocalDate getProjectStartDate() { return projectStartDate; }
    public void setProjectStartDate(LocalDate projectStartDate) { this.projectStartDate = projectStartDate; }

    public LocalDate getProjectEndDate() { return projectEndDate; }
    public void setProjectEndDate(LocalDate projectEndDate) { this.projectEndDate = projectEndDate; }

    @Override
    public String toString() {
        return "Project [id=" + id + ", projectCode=" + projectCode + ", description=" + description
                + ", status=" + status + ", projectOwner=" + (projectOwner != null ? projectOwner.getId() : null)
                + ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate + "]";
    }
}
