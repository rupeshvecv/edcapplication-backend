package com.empoweredge.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_table" , schema="empoweredge") 
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Transient
	private String error;
	
	@Column(name= "emp_code")
	private String empCode;
	
	@Column(name= "user_name")
	private String name;
	
	@Column(name= "user_password")
	private String password;
	
	@Column(name= "user_email")
	private String email;
	
	@Column(name= "user_contact_no")
	private String contactNo;
	
	@Column(name= "first_name")
	private String firstName;
	
	@Column(name= "middle_name")
	private String middleName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Column(name= "status")
	private String status;
	
	@Column(name= "superior")
	private String superior;
	
	@Column(name= "department_name")
	private String departmentName;
	
	@Column(name= "designation")
	private String designation;
	
	@Column(name= "hrbp_name")
	private String hrbpName;
	
	@Column(name= "originated")
	private LocalDate originated;
	
	@OneToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	public User() {
		super();
	}

	public User(Integer id, String error, String empCode, String name, String password, String email, String contactNo,
			String firstName, String middleName, String lastName, String status, String superior, String departmentName,
			String designation, String hrbpName, LocalDate originated, Role role) {
		super();
		this.id = id;
		this.error = error;
		this.empCode = empCode;
		this.name = name;
		this.password = password;
		this.email = email;
		this.contactNo = contactNo;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.status = status;
		this.superior = superior;
		this.departmentName = departmentName;
		this.designation = designation;
		this.hrbpName = hrbpName;
		this.originated = originated;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSuperior() {
		return superior;
	}

	public void setSuperior(String superior) {
		this.superior = superior;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getHrbpName() {
		return hrbpName;
	}

	public void setHrbpName(String hrbpName) {
		this.hrbpName = hrbpName;
	}

	public LocalDate getOriginated() {
		return originated;
	}

	public void setOriginated(LocalDate originated) {
		this.originated = originated;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", error=" + error + ", empCode=" + empCode + ", name=" + name + ", password="
				+ password + ", email=" + email + ", contactNo=" + contactNo + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", status=" + status + ", superior="
				+ superior + ", departmentName=" + departmentName + ", designation=" + designation + ", hrbpName="
				+ hrbpName + ", originated=" + originated + ", role=" + role + "]";
	}

}
