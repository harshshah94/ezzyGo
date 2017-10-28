package com.app.ezzygo.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "UserDetails" database table.
 * 
 */
@Entity
@Table(name="\"UserDetails\"")
@NamedQuery(name="UserPojo.findAll", query="SELECT u FROM UserPojo u")
public class UserPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"email\"")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="\"dateOfBirth\"")
	private Date dateOfBirth;

	@Column(name="\"firstName\"")
	private String firstName;

	@Column(name="\"gender\"")
	private String gender;

	@Column(name="\"lastName\"")
	private String lastName;

	@Column(name="\"mobile\"")
	private String mobile;

	//bi-directional many-to-one association to BusPojo
	@OneToMany(mappedBy="userDetail")
	private List<BusPojo> busDetails;

	//bi-directional one-to-one association to LoginPojo
	@OneToOne(mappedBy="userDetail1", fetch=FetchType.LAZY)
	private LoginPojo loginDetail1;

	//bi-directional one-to-one association to LoginPojo
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private LoginPojo loginDetail2;

	public UserPojo() {
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

	public List<BusPojo> getBusDetails() {
		return this.busDetails;
	}

	public void setBusDetails(List<BusPojo> busDetails) {
		this.busDetails = busDetails;
	}

	public BusPojo addBusDetail(BusPojo busDetail) {
		getBusDetails().add(busDetail);
		busDetail.setUserDetail(this);

		return busDetail;
	}

	public BusPojo removeBusDetail(BusPojo busDetail) {
		getBusDetails().remove(busDetail);
		busDetail.setUserDetail(null);

		return busDetail;
	}

	public LoginPojo getLoginDetail1() {
		return this.loginDetail1;
	}

	public void setLoginDetail1(LoginPojo loginDetail1) {
		this.loginDetail1 = loginDetail1;
	}

	public LoginPojo getLoginDetail2() {
		return this.loginDetail2;
	}

	public void setLoginDetail2(LoginPojo loginDetail2) {
		this.loginDetail2 = loginDetail2;
	}

}