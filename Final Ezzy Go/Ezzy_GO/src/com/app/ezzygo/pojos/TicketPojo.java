package com.app.ezzygo.pojos;

import java.io.Serializable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "TicketDetails")
@NamedQuery(name = "TicketPojo.findAll", query = "SELECT t FROM TicketPojo t")
public class TicketPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticketId",columnDefinition="number(10)",nullable=false)
	private Long ticketId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "routeId",nullable=false)
	private SchedulePojo scheduleDetail;

	@Column(name = "email",columnDefinition="varchar2(30)",nullable=false)
	private String email;

	@Column(name = "mobile",columnDefinition="char(13)",nullable=false)
	private String mobile;

	@Column(name = "numberOfSeats",columnDefinition="number(2)",nullable=false)
	private Integer numberOfSeats;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "boardingId",nullable=false)
	private BoardingPojo boardingDetail;

	@Temporal(TemporalType.DATE)
	@Column(name = "dateOfBooking",nullable=false)
	private Date dateOfBooking;

	@Column(name = "totalFare",columnDefinition="number(5)",nullable=false)
	private Integer totalFare;

	// bi-directional many-to-one association to PassengerPojo
	@OneToMany(mappedBy = "ticketDetail")
	private Collection<PassengerPojo> passengerDetails = new ArrayList<>();

	public TicketPojo() {
	}

	public long getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public Date getDateOfBooking() {
		return this.dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getNumberOfSeats() {
		return this.numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Integer getTotalFare() {
		return this.totalFare;
	}

	public void setTotalFare(Integer totalFare) {
		this.totalFare = totalFare;
	}

	public Collection<PassengerPojo> getPassengerDetails() {
		return this.passengerDetails;
	}

	public void setPassengerDetails(Collection<PassengerPojo> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	public PassengerPojo addPassengerDetail(PassengerPojo passengerDetail) {
		getPassengerDetails().add(passengerDetail);
		passengerDetail.setTicketDetail(this);

		return passengerDetail;
	}

	public PassengerPojo removePassengerDetail(PassengerPojo passengerDetail) {
		getPassengerDetails().remove(passengerDetail);
		passengerDetail.setTicketDetail(null);

		return passengerDetail;
	}

	public BoardingPojo getBoardingDetail() {
		return this.boardingDetail;
	}

	public void setBoardingDetail(BoardingPojo boardingDetail) {
		this.boardingDetail = boardingDetail;
	}

	public SchedulePojo getScheduleDetail() {
		return this.scheduleDetail;
	}

	public void setScheduleDetail(SchedulePojo scheduleDetail) {
		this.scheduleDetail = scheduleDetail;
	}

}