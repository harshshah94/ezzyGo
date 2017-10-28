package com.app.ezzygo.pojos;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the "UserDetails" database table.
 * 
 */
@Entity
@Table(name = "UserDetails")
@NamedQuery(name = "UserPojo.findAll", query = "SELECT u FROM UserPojo u")
public class UserPojo implements Serializable {

	@Override
	public boolean equals(Object obj) {
		return this.email.equals(((UserPojo) obj).email);
	}

	@Override
	public String toString() {
		return "UserPojo [email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", mobile=" + mobile + ", role=" + role + ", active="
				+ active + ", busDetails=" + busDetails + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Email(message = "Enter valid Email")
	@NotEmpty(message = "Email should not be empty")
	@Column(name = "email", columnDefinition = "varchar2(30)", nullable = false)
	private String email;

	@Length(min = 8, max = 16, message = "Password length should be in between 8 to 16")
	@Column(name = "password", nullable = false, columnDefinition = "varchar2(100)")
	@NotEmpty(message = "Password should not be empty")
	private String password;

	@NotEmpty(message = "First name should not be empty")
	@Column(name = "firstName", columnDefinition = "varchar2(20)", nullable = false)
	private String firstName;

	@Column(name = "lastName", columnDefinition = "varchar2(20)")
	private String lastName;

	@NotEmpty(message = "Please select gender")
	@Column(name = "gender", columnDefinition = "char(1)", nullable = false)
	private String gender;

	// @NotEmpty(message = "Please select Date of Birth")
	@Temporal(TemporalType.DATE)
	// @DateTimeFormat(pattern = "dd-MMM-yyyy")
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;

	@Length(min = 10, max = 13, message = "Enter valid Mobile Number")
	@Column(name = "mobile", columnDefinition = "char(13)", nullable = false)
	private String mobile;

	@Column(name = "role", columnDefinition = "char(5)", nullable = false)
	private String role;

	@Column(name = "active", columnDefinition = "char(1)")
	private String active;

	// bi-directional many-to-one association to BusPojo
	@OneToMany(mappedBy = "agentDetails", fetch = FetchType.LAZY)
	private Collection<BusPojo> busDetails = new ArrayList<BusPojo>();

	public UserPojo() {
	}

	public UserPojo(String email, String password, Date dateOfBirth,
			String firstName, String gender, String lastName, String mobile,
			String role, String active) {
		super();
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.mobile = mobile;
		this.role = role;
		this.active = active;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;

	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Collection<BusPojo> getBusDetails() {
		return this.busDetails;
	}

	public void setBusDetails(List<BusPojo> busDetails) {
		this.busDetails = busDetails;
	}

	public BusPojo addBusDetail(BusPojo busDetail) {
		getBusDetails().add(busDetail);
		busDetail.setAgentDetails(this);

		return busDetail;
	}

	public BusPojo removeBusDetail(BusPojo busDetail) {
		getBusDetails().remove(busDetail);
		busDetail.setAgentDetails(null);

		return busDetail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String object) {
		this.role = object;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}