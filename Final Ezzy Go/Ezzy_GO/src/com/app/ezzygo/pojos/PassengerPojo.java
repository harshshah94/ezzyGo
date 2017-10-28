package com.app.ezzygo.pojos;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the "PassengerDetails" database table.
 * 
 */
@Entity
@Table(name = "PassengerDetails")
@NamedQuery(name = "PassengerPojo.findAll", query = "SELECT p FROM PassengerPojo p")
public class PassengerPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "passengerId",columnDefinition="number(10)",nullable=false)
	private Long passengerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticketId")
	private TicketPojo ticketDetail;

	@Column(name = "seatId",columnDefinition="number(6)",nullable=false)
	private Long seatId;

	@Column(name = "name",columnDefinition="varchar2(30)",nullable=false)
	private String name;

	@Column(name = "age",columnDefinition="number(3)",nullable=false)
	private Integer age;

	@Column(name = "gender",columnDefinition="char(1)",nullable=false)
	private String gender;

	public PassengerPojo() {
	}
	
	public PassengerPojo(TicketPojo ticketDetail, Long seatId, String name,
			Integer age, String gender) {
		super();
		this.ticketDetail = ticketDetail;
		this.seatId = seatId;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Long getPassengerId() {
		return this.passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSeatId() {
		return this.seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public TicketPojo getTicketDetail() {
		return this.ticketDetail;
	}

	public void setTicketDetail(TicketPojo ticketDetail) {
		this.ticketDetail = ticketDetail;
	}

}