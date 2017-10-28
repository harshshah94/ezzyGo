package com.app.ezzygo.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "LoginDetails" database table.
 * 
 */
@Entity
@Table(name="\"LoginDetails\"")
@NamedQuery(name="LoginPojo.findAll", query="SELECT l FROM LoginPojo l")
public class LoginPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"loginId\"")
	private long loginId;

	@Column(name="\"email\"")
	private String email;

	@Column(name="\"password\"")
	private String password;

	@Column(name="\"role\"")
	private String role;

	//bi-directional one-to-one association to UserPojo
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private UserPojo userDetail1;

	//bi-directional one-to-one association to UserPojo
	@OneToOne(mappedBy="loginDetail2", fetch=FetchType.LAZY)
	private UserPojo userDetail2;

	public LoginPojo() {
	}

	public long getLoginId() {
		return this.loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserPojo getUserDetail1() {
		return this.userDetail1;
	}

	public void setUserDetail1(UserPojo userDetail1) {
		this.userDetail1 = userDetail1;
	}

	public UserPojo getUserDetail2() {
		return this.userDetail2;
	}

	public void setUserDetail2(UserPojo userDetail2) {
		this.userDetail2 = userDetail2;
	}

}