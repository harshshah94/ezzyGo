package com.app.ezzygo.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "ScheduleDetails" database table.
 * 
 */
@Entity
@Table(name="\"ScheduleDetails\"")
@NamedQuery(name="SchedulePojo.findAll", query="SELECT s FROM SchedulePojo s")
public class SchedulePojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"routeId\"")
	private long routeId;

	@Column(name="\"arrivalTime\"")
	private Timestamp arrivalTime;

	@Column(name="\"busId\"")
	private BigDecimal busId;

	@Temporal(TemporalType.DATE)
	@Column(name="\"dateOfJourney\"")
	private Date dateOfJourney;

	@Column(name="\"departureTime\"")
	private Timestamp departureTime;

	@Column(name="\"destinationCity\"")
	private BigDecimal destinationCity;

	@Column(name="\"remainingSeats\"")
	private BigDecimal remainingSeats;

	@Column(name="\"seatFare\"")
	private BigDecimal seatFare;

	@Column(name="\"sleepFare\"")
	private BigDecimal sleepFare;

	@Column(name="\"sourceCity\"")
	private BigDecimal sourceCity;

	//bi-directional many-to-one association to BusPojo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private BusPojo busDetail;

	//bi-directional many-to-one association to CityPojo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private CityPojo cityDetail1;

	//bi-directional many-to-one association to CityPojo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private CityPojo cityDetail2;

	//bi-directional many-to-one association to TicketPojo
	@OneToMany(mappedBy="scheduleDetail")
	private List<TicketPojo> ticketDetails;

	public SchedulePojo() {
	}

	public long getRouteId() {
		return this.routeId;
	}

	public void setRouteId(long routeId) {
		this.routeId = routeId;
	}

	public Timestamp getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public BigDecimal getBusId() {
		return this.busId;
	}

	public void setBusId(BigDecimal busId) {
		this.busId = busId;
	}

	public Date getDateOfJourney() {
		return this.dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public Timestamp getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	public BigDecimal getDestinationCity() {
		return this.destinationCity;
	}

	public void setDestinationCity(BigDecimal destinationCity) {
		this.destinationCity = destinationCity;
	}

	public BigDecimal getRemainingSeats() {
		return this.remainingSeats;
	}

	public void setRemainingSeats(BigDecimal remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	public BigDecimal getSeatFare() {
		return this.seatFare;
	}

	public void setSeatFare(BigDecimal seatFare) {
		this.seatFare = seatFare;
	}

	public BigDecimal getSleepFare() {
		return this.sleepFare;
	}

	public void setSleepFare(BigDecimal sleepFare) {
		this.sleepFare = sleepFare;
	}

	public BigDecimal getSourceCity() {
		return this.sourceCity;
	}

	public void setSourceCity(BigDecimal sourceCity) {
		this.sourceCity = sourceCity;
	}

	public BusPojo getBusDetail() {
		return this.busDetail;
	}

	public void setBusDetail(BusPojo busDetail) {
		this.busDetail = busDetail;
	}

	public CityPojo getCityDetail1() {
		return this.cityDetail1;
	}

	public void setCityDetail1(CityPojo cityDetail1) {
		this.cityDetail1 = cityDetail1;
	}

	public CityPojo getCityDetail2() {
		return this.cityDetail2;
	}

	public void setCityDetail2(CityPojo cityDetail2) {
		this.cityDetail2 = cityDetail2;
	}

	public List<TicketPojo> getTicketDetails() {
		return this.ticketDetails;
	}

	public void setTicketDetails(List<TicketPojo> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}

	public TicketPojo addTicketDetail(TicketPojo ticketDetail) {
		getTicketDetails().add(ticketDetail);
		ticketDetail.setScheduleDetail(this);

		return ticketDetail;
	}

	public TicketPojo removeTicketDetail(TicketPojo ticketDetail) {
		getTicketDetails().remove(ticketDetail);
		ticketDetail.setScheduleDetail(null);

		return ticketDetail;
	}

}