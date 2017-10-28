package com.app.ezzygo.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the "PassengerDetails" database table.
 * 
 */
@Entity
@Table(name="\"PassengerDetails\"")
@NamedQuery(name="PassengerPojo.findAll", query="SELECT p FROM PassengerPojo p")
public class PassengerPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"passengerId\"")
	private long passengerId;

	@Column(name="\"age\"")
	private BigDecimal age;

	@Column(name="\"gender\"")
	private String gender;

	@Column(name="\"name\"")
	private String name;

	@Column(name="\"seatId\"")
	private BigDecimal seatId;

	@Column(name="\"ticketId\"")
	private BigDecimal ticketId;

	//bi-directional many-to-one association to TicketPojo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private TicketPojo ticketDetail;

	public PassengerPojo() {
	}

	public long getPassengerId() {
		return this.passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public BigDecimal getAge() {
		return this.age;
	}

	public void setAge(BigDecimal age) {
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

	public BigDecimal getSeatId() {
		return this.seatId;
	}

	public void setSeatId(BigDecimal seatId) {
		this.seatId = seatId;
	}

	public BigDecimal getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(BigDecimal ticketId) {
		this.ticketId = ticketId;
	}

	public TicketPojo getTicketDetail() {
		return this.ticketDetail;
	}

	public void setTicketDetail(TicketPojo ticketDetail) {
		this.ticketDetail = ticketDetail;
	}

}