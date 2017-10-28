package com.app.ezzygo.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "TicketDetails" database table.
 * 
 */
@Entity
@Table(name="\"TicketDetails\"")
@NamedQuery(name="TicketPojo.findAll", query="SELECT t FROM TicketPojo t")
public class TicketPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"ticketId\"")
	private long ticketId;

	@Column(name="\"boardingId\"")
	private BigDecimal boardingId;

	@Temporal(TemporalType.DATE)
	@Column(name="\"dateOfBooking\"")
	private Date dateOfBooking;

	@Column(name="\"email\"")
	private String email;

	@Column(name="\"mobile\"")
	private BigDecimal mobile;

	@Column(name="\"numberOfSeats\"")
	private BigDecimal numberOfSeats;

	@Column(name="\"routeId\"")
	private BigDecimal routeId;

	@Column(name="\"totalFare\"")
	private BigDecimal totalFare;

	//bi-directional many-to-one association to PassengerPojo
	@OneToMany(mappedBy="ticketDetail")
	private List<PassengerPojo> passengerDetails;

	//bi-directional many-to-one association to BoardingPojo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private BoardingPojo boardingDetail;

	//bi-directional many-to-one association to SchedulePojo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private SchedulePojo scheduleDetail;

	public TicketPojo() {
	}

	public long getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public BigDecimal getBoardingId() {
		return this.boardingId;
	}

	public void setBoardingId(BigDecimal boardingId) {
		this.boardingId = boardingId;
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

	public BigDecimal getMobile() {
		return this.mobile;
	}

	public void setMobile(BigDecimal mobile) {
		this.mobile = mobile;
	}

	public BigDecimal getNumberOfSeats() {
		return this.numberOfSeats;
	}

	public void setNumberOfSeats(BigDecimal numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public BigDecimal getRouteId() {
		return this.routeId;
	}

	public void setRouteId(BigDecimal routeId) {
		this.routeId = routeId;
	}

	public BigDecimal getTotalFare() {
		return this.totalFare;
	}

	public void setTotalFare(BigDecimal totalFare) {
		this.totalFare = totalFare;
	}

	public List<PassengerPojo> getPassengerDetails() {
		return this.passengerDetails;
	}

	public void setPassengerDetails(List<PassengerPojo> passengerDetails) {
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